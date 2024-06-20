package org.zerock.api01.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class APIUser {
  @Id
  private String mid;
  private String mpw;
  private String mname;
  private String email;
  public void changeMname(String mname){
    this.mname = mname;
  }
  public void changeMpw(String mpw){
    this.mpw = mpw;
  }
  public void changeEmail(String email){
    this.email = email;
  }
}
