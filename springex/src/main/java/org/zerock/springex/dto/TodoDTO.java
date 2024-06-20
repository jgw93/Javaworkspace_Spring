package org.zerock.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
  // DTO(Data Transfer Object) : 프레젠테이션 계층, 보여주는 층.
  // 결론, 실제 DB 에서, 5개의 정보가 있음.
  // 그런데, 내가 실제로 보여줄려는 정보는 3개만 골라서 사용도 가능.
  private Long tno;

  @NotEmpty
  private String title;

  @Future
  private LocalDate dueDate;

  private boolean finished;

  @NotEmpty
  private String writer;
}


