package org.zerock.b01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.b01.domain.Notice;

public interface NoticeSearch {
    Page<Notice> searchAll(String keyword, Pageable pageable);
}
