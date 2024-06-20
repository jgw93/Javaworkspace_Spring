package org.zerock.b01.service;

import org.zerock.b01.dto.MemberJoinDTO;

public interface MemberService {
    static class MidExistException extends Exception {
    }
    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;
    void modify(MemberJoinDTO memberJoinDTO);
    void remove(String mid);
    boolean check(String mid); // 중복 체크 메서드 추가

}
