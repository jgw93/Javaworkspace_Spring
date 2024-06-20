package org.zerock.bookmarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.bookmarket.domain.Member;
import org.zerock.bookmarket.dto.MemberDTO;

@Mapper
public interface MemberMapper {

    void insert(Member member);

    Member findIdAndPw(Member member);

}
