package org.zerock.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.bookmarket.dto.MemberDTO;
import org.zerock.bookmarket.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public void join() {
        log.info("GET join.......");
    }

    @PostMapping("/join")
    public String addjoin(@Valid MemberDTO memberDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("has errors......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/member/join";
        }
        log.info(memberDTO);

        memberService.join(memberDTO);

        return "redirect:/";
    }

    @GetMapping("/login")
    public void loginGet() {
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest req,
                            Model model,
                            MemberDTO memberDTO) {
        try {
            MemberDTO loginInfo = memberService.login(memberDTO);
            System.out.println(loginInfo);
            HttpSession session = req.getSession(true);
            session.setAttribute("loginInfo", loginInfo);
            model.addAttribute("info", loginInfo);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/member/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();
        return "redirect:/";

    }
}
