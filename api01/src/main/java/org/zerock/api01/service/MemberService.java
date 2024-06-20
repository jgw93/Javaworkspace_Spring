package org.zerock.api01.service;

import org.zerock.api01.dto.APIUserJoinDTO;

public interface MemberService {
    static class MidExistException extends Exception {
    }
    void join(APIUserJoinDTO apiUserJoinDTO) throws MidExistException;
    void modify(APIUserJoinDTO apiUserJoinDTO);
    APIUserJoinDTO getUserByMid(String mid);
    void deleteUserByMid(String mid);
}
