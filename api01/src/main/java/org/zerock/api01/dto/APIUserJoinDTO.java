package org.zerock.api01.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class APIUserJoinDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String email;

    public void setPassword(String mpw) {
        this.mpw = mpw;
    }
    public String getPassword() {
        return mpw;
    }
}
