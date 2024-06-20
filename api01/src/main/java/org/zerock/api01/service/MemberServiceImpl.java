package org.zerock.api01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.api01.domain.APIUser;
import org.zerock.api01.domain.Todo;
import org.zerock.api01.dto.APIUserDTO;
import org.zerock.api01.dto.APIUserJoinDTO;
import org.zerock.api01.dto.TodoDTO;
import org.zerock.api01.repository.APIUserRepository;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final ModelMapper modelMapper;
    private final APIUserRepository apiUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(APIUserJoinDTO apiUserJoinDTO) throws MidExistException {
        log.info("======================");
        log.info(apiUserJoinDTO);
        // 화면에서 가지고온 ID를 저장
        String mid = apiUserJoinDTO.getMid();
        // 아이디가 존재하지 않으면 Member객체로 변환
        APIUser apiUser = modelMapper.map(apiUserJoinDTO, APIUser.class);
        log.info("======================");
        log.info(apiUser);
        // 데이터베이스에 저장
        apiUserRepository.save(apiUser);
    }

//    @Override
//    public void modify(String mpw, String mid) {
//        apiUserRepository.updatePassword(mid, passwordEncoder.encode(mpw));
//    }
    @Override
    public void modify(APIUserJoinDTO apiUserJoinDTO) {
        Optional<APIUser> result = apiUserRepository.findById(apiUserJoinDTO.getMid());
        APIUser apiUser = result.orElseThrow();
        apiUser.changeMname(apiUserJoinDTO.getMname());
        apiUser.changeMpw(passwordEncoder.encode(apiUserJoinDTO.getMpw()));
        apiUser.changeEmail(apiUserJoinDTO.getEmail());
        apiUserRepository.save(apiUser);
    }

    @Override
    public APIUserJoinDTO getUserByMid(String mid) {
        Optional<APIUser> result = apiUserRepository.findByMid(mid);
        APIUser apiUser = result.orElseThrow();
        return modelMapper.map(apiUser, APIUserJoinDTO.class);
    }
    @Override
    public void deleteUserByMid(String mid) {
        apiUserRepository.deleteById(mid);
    }
}
