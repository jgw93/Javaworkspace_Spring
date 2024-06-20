package org.zerock.b01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.b01.service.ProgramService;

@Controller
@RequestMapping("/program")
@Log4j2
@RequiredArgsConstructor
public class ProgramController {
  private final ProgramService programService;
  @GetMapping("/list")
  public String list(Model model){
    model.addAttribute("programList", programService.selectAll());
    return "/ex/program";
  }
}
