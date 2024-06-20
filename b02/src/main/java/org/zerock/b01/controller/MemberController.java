package org.zerock.b01.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.b01.domain.Member;
import org.zerock.b01.dto.MemberDTO;
import org.zerock.b01.service.MemberService;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String join(MemberDTO memberDTO) {
        return "/ex/join";
    }

    @PostMapping("/join")
    public String addjoin(MemberDTO memberDTO) {
        memberDTO.setEmail1(memberDTO.getMemberId());
        memberService.register(memberDTO);
        return "redirect:/ex/index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/ex/login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest req, Model model,
                        String memberId,
                        String memberPw,
                        RedirectAttributes redirectAttributes) {
        try {
            MemberDTO loginInfo = memberService.login(memberId, memberPw);
            System.out.println(loginInfo);
            HttpSession session = req.getSession(true);
            session.setAttribute("loginInfo", loginInfo);
            model.addAttribute("info", loginInfo);
            return "redirect:/ex/index";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "아이디와 비밀번호를 확인해주세요.");
            return "redirect:/member/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req, Model model) {
        // session을 변수로 설정했기 때문에 중복 사용 가능
        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();
        // session을 만들지 않고 getSession의 결과물에 바로 메서드를 실행하는 방식 : 중복 사용 불가능
//        req.getSession().removeAttribute("loginInfo");
//        req.getSession().invalidate();
        return "redirect:/ex/index";
    }
}

//    @PostMapping("/login")
//    public String login(MemberDTO memberDTO,
//                           RedirectAttributes redirectAttributes,
//                           BindingResult bindingResult,
//                           HttpSession session) {
//
//        // 사용자가 입력한 ID와 PW를 이용하여 데이터베이스에서 멤버를 검색합니다.
//        MemberDTO member = memberService.login(memberDTO.getMemberId());
//
//        // 멤버가 존재하고, 비밀번호가 일치하면 로그인 성공
//        if (member != null && member.getMemberPw().equals(memberDTO.getMemberPw())) {
//            // 세션에 사용자 정보 저장
//            session.setAttribute("loggedInMember", member);
//            // 로그인 성공 후 리다이렉트할 URL
//            return "redirect:/ex/index";
//        } else {
//            // 로그인 실패 시 에러 메시지를 플래시 어트리뷰트에 저장하고 로그인 페이지로 리다이렉트
//            redirectAttributes.addFlashAttribute("error", "ID 또는 비밀번호가 올바르지 않습니다.");
//            return "redirect:/login";
//        }
//    }


