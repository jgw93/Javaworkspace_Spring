package org.zerock.b01.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b01.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    @EntityGraph(attributePaths = "roleSet")
    @Query("select m from Member m where m.mid = :mid and m.social = false ")
    Optional<Member> getWithRoles(String mid);

    @EntityGraph(attributePaths = "roleSet")
    Optional<Member> findByMid(String mid);

    @Modifying
    @Transactional
    @Query("update Member m set m.mpw = :mpw, m.checkmpw = :cmpw, m.name = :name, m.email = :email, m.address = :address where m.mid = :mid")
    void updateMember(String mid, String mpw, String cmpw, String name, String email, String address);

}
