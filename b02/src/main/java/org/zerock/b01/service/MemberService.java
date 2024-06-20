package org.zerock.b01.service;

import org.zerock.b01.domain.Member;
import org.zerock.b01.dto.MemberDTO;

public interface MemberService {
    void register(MemberDTO memberDTO);
    MemberDTO login(String memberId, String memberPw);


}
