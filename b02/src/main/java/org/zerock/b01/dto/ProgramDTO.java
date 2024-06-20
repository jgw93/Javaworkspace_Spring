package org.zerock.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDTO {
    private Integer no;
    private String title;
    private String text;
    private String subtext;
    private String schedule;
    private String img;
    private LocalDate regDate;
    private LocalDate modDate;
}
