package org.zerock.b01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.b01.domain.Member2;

import java.util.Optional;

public interface MemberRepository2 extends JpaRepository<Member2,String> {
  @Query(value = "SELECT member_id,member_pw, name, phone, email1, email2, gender, agree, moddate, regdate FROM member WHERE member_id = ?1 AND member_pw = ?2", nativeQuery = true)
  Optional<Member2> findByIdAndPw(String id, String pw);
}
