package org.zerock.b01.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b01.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice,Long>,NoticeSearch {
}
