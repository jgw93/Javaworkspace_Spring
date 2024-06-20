package org.zerock.api01.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class APIUserDTO extends User {
  private String mid;
  private String mpw;
  private String mname;
  private String email;

  // APIUserDTO 생성자 : UserDetails에 아이디, 패스워드, 권한을 설정하기 위한 생성자
  public APIUserDTO(String username, String password, String mname, String email, Collection<GrantedAuthority> authorities) {
    super(username, password, authorities);
    this.mid = username;
    this.mpw = password;
    this.mname = mname;
    this.email = email;
  }
}
