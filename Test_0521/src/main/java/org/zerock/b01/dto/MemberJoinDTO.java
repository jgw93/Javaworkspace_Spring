package org.zerock.b01.dto;

import lombok.Data;

@Data
public class MemberJoinDTO {
    private String mid;
    private String mpw;
    private String email;
    private String checkmpw;
    private String name;
    private String address;
    private boolean del;
    private boolean social;
}
