package org.zerock.api01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.api01.domain.APIUser;

import java.util.Optional;

public interface APIUserRepository extends JpaRepository<APIUser, String> {

    Optional<APIUser> findByMid(String mid);

    @Modifying
    @Transactional
    @Query("update APIUser m set m.mpw =:mpw where m.mid = :mid")
    void updatePassword(@Param("mpw") String mpw, @Param("mid") String mid);


}
