package org.zerock.bookmarket.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.bookmarket.domain.Member;
import org.zerock.bookmarket.dto.MemberDTO;
import org.zerock.bookmarket.mapper.MemberMapper;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;

    @Override
    public void join(MemberDTO memberDTO) {
        log.info(modelMapper);
        Member member = modelMapper.map(memberDTO, Member.class);
        log.info(member);
        memberMapper.insert(member);
    }

    @Override
    public MemberDTO login(MemberDTO memberDTO) {
        Member member = memberMapper.findIdAndPw(modelMapper.map(memberDTO, Member.class));
        return modelMapper.map(member, MemberDTO.class);
    }
}
