package org.zerock.b01.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.b01.dto.MemberJoinDTO;
import org.zerock.b01.service.MemberService;
import org.zerock.b01.service.MemberServiceImpl;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SampleJSONController {
  private final MemberService memberService;

  @Tag(name = "스웨거 ui 화면에 나타나는지 여부 확인 테스트", description = "스웨거 ui 화면에 나타나는지 여부 확인 테스트")
  @GetMapping("/helloArr")
  public String[] helloArr(){
    log.info("helloArr................");
    // 화면을 찾는것 아니라 JSON데이터를 반환
    return new String[]{"AAA","BBB","CCC"};
  }

  @Tag(name = "샘플로 테스트2", description = "오늘 점심 먹고 싶은 메뉴 작성 해보기")
  @GetMapping("/lunchMenu")
  public String[] lunchMenu(){
    log.info("lunchMenu................");
    // 화면을 찾는것 아니라 JSON데이터를 반환
    return new String[]{"돼지국밥","햄버거","피자"};
  }

  //RestController를 이용한 데이터 통신 : 데이터만 주고받기 때문에 화면을 갱신시키지 않음
  @GetMapping("/check")
  //아이디의 존재 여부 확인 메서드 반환값으로 boolean 사용
  public boolean check(String memberId){
    //아이디 존여부를 확인하고 결과값 리턴
    return memberService.check(memberId);
  }
//  @PostMapping("/check/{mid}")
//  public ResponseEntity<Boolean> check(@PathVariable("mid") String mid, @RequestBody MemberJoinDTO memberJoinDTO) {
//    memberJoinDTO.setMid(mid);
//    boolean exists = memberService.check(mid);
//    return ResponseEntity.ok(exists);
//  }
}
