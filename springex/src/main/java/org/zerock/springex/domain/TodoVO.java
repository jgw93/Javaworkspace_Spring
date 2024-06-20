package org.zerock.springex.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
  // VO(Value Object) : 비즈니스 데이터를 처리하는 모델.
  // 실제 데이터 베이스에서 사용하는 정보를 전체를 다 받는 용도.
  private Long tno;
  private String title;
  private LocalDate dueDate;
  private String writer;
  private boolean finished;
}








