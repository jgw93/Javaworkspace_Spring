package org.zerock.bookmarket.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    private String memberID;
    private String memberPW;
    private String memberName;
    private String phone;
    private String address;
    private String email;
    private LocalDateTime createDate;
}
