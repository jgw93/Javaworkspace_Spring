package org.zerock.b01.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.b01.dto.ProgramDTO;
import org.zerock.b01.repository.ProgramRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProgramDTO> selectAll() {
        return programRepository.findAll().stream()
                .map(program -> modelMapper.map(program, ProgramDTO.class))
                .collect(Collectors.toList());
    }
}
