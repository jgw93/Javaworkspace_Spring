package org.zerock.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO2 {
  private String member_id;
  private String member_pw;
  private String name;
  private String phone;
  private String email1;
  private String email2;
  private String gender;
  private boolean agree;
}
