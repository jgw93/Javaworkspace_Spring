package org.zerock.b01.service;

import org.zerock.b01.dto.NoticeDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;

public interface NoticeService {
  Long register(NoticeDTO noticeDTO);
  NoticeDTO readOne(Long no);
  void modify(NoticeDTO noticeDTO);
  void remove(Long no);
  PageResponseDTO<NoticeDTO> list(PageRequestDTO pageRequestDTO);
}
















