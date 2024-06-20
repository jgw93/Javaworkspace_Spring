package org.zerock.b01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SampleJSONController {
  @GetMapping("/helloArr")
  public String[] helloArr(){
    log.info("helloArr................");
    // 화면을 찾는것 아니라 JSON데이터를 반환
    return new String[]{"AAA","BBB","CCC"};
  }
}
