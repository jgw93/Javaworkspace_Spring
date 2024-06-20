package org.zerock.bookmarket.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    @NotEmpty
    private String memberID;
    @NotEmpty
    private String memberPW;
    private String memberName;
    private String phone;
    private String address;
    private String email;
    private LocalDateTime createDate;
}
