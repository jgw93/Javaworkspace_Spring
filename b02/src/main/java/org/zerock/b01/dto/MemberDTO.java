package org.zerock.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long mno;
    private String memberId;
    private String memberPw;
    private String name;
    private String phone;
    private String email1;
    private String email2;
    private String gender;
    private boolean agree;
}
