package org.zerock.bookmarket.service;

import org.springframework.stereotype.Service;
import org.zerock.bookmarket.dto.MemberDTO;

@Service
public interface MemberService {
    void join(MemberDTO memberDTO);
    MemberDTO login(MemberDTO memberDTO);
}
