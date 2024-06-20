package org.zerock.b01.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b01.domain.Notice;
import org.zerock.b01.repository.search.NoticeSearch;

public interface NoticeRepository extends JpaRepository<Notice,Long>, NoticeSearch {
}
