package org.zerock.b01.service;

import org.zerock.b01.dto.ProgramDTO;

import java.util.List;

public interface ProgramService {
  List<ProgramDTO> selectAll();
}
