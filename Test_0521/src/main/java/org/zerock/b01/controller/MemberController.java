package org.zerock.b01.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.b01.domain.Member;
import org.zerock.b01.dto.MemberJoinDTO;
import org.zerock.b01.repository.MemberRepository;
import org.zerock.b01.service.MemberService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    //의존성 주입
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public void loginGET(String errorCode, String logout) {
        log.info("login get...............");
        log.info("logout: " + logout);

        if (logout != null) {
            log.info("user logout.............");
        }
    }

    @GetMapping("/join")
    public void joinGET() {
        log.info("join get...........");
    }

    @PostMapping("/join")
    public String joinPOST(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes) {
        log.info("join post..........");
        log.info(memberJoinDTO);

        try {
            //회원가입 서비스 실행
            memberService.join(memberJoinDTO);
            //아이디가 존재 할 경우 에러 발생
        } catch (MemberService.MidExistException e) {
            //에러 발생시 리다이렉트 페이지에 error=mid 값을 가지고 이동
            redirectAttributes.addFlashAttribute("error", "mid");
            return "redirect:/member/join";
        }
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/member/login"; //회원가입 후 로그인
    }

    @GetMapping("/modify")
    public void modifyGET(Principal principal, Model model) {
        log.info("modify get...........");
        String memberId = principal.getName();
        Optional<Member> memberOptional = memberRepository.findByMid(memberId);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            model.addAttribute("member", member);
        } else {
            log.warn("사용자 정보를 찾을 수 없습니다: " + memberId);
        }
    }

    @PostMapping("/modify")
    public String modifyPOST(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes) {
        log.info("modify post...........");
        memberService.modify(memberJoinDTO);
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(String mid, RedirectAttributes redirectAttributes, HttpSession session) {
        memberService.remove(mid);
        session.invalidate();
        redirectAttributes.addFlashAttribute("result", "removed");
        return "redirect:/board/list";
    }




//    @PostMapping("/check")
//    public String checkerPOST(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes, Model model) {
//        boolean exist = memberService.check(memberJoinDTO);
//        if(exist) {
//            log.info("Yes");
//            redirectAttributes.addFlashAttribute("error", "mid");
//        } else {
//            log.info("No");
//            redirectAttributes.addFlashAttribute("success", "mid");
//        }
//        model.addAttribute("member", memberJoinDTO);
//        return "redirect:/member/join";
//    }

}

