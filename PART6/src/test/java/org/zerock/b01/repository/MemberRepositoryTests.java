package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.zerock.b01.domain.Member;
import org.zerock.b01.domain.MemberRole;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMembers(){
        //1~100까지 반복하기 위한 스트림
        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder()
                    .mid("member" + i)
                    //비밀번호 암호화
                    .mpw(passwordEncoder.encode("1111"))
                    .email("email"+i+"@aaa.bbb")
                    .build();
            //일반 회원의 권한 설정
            member.addRole(MemberRole.USER);

            if (i >= 90){
                //관리자 권한 설정
                member.addRole(MemberRole.ADMIN);
            }
            memberRepository.save(member);
        });
    }

    @Test
    public void testRead(){
        //데이터 베이스에서 mid를 기준으로 데이터를 취득
        Optional<Member> result = memberRepository.getWithRoles("member100");
        //에러 확인
        Member member = result.orElseThrow();
        //전체 데이터 출력
        log.info(member);
        //role 데이터 출력
        log.info(member.getRoleSet());

        member.getRoleSet().forEach(memberRole -> log.info(memberRole.name()));
    }

    @Commit
    @Test
    public void testUpdate() {
        String mid = "kmmh99@naver.com";
        String mpw = passwordEncoder.encode("54321");

        memberRepository.updatePassword(mpw, mid);
    }
}
