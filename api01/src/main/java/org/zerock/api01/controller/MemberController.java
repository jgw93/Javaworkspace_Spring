package org.zerock.api01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.api01.dto.APIUserJoinDTO;
import org.zerock.api01.dto.APIUserDTO;  // 필요한 DTO 추가
import org.zerock.api01.service.MemberService;

import java.util.Map;

@RestController
@RequestMapping("/api/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @CrossOrigin
    @PostMapping("/join")
    public String joinPOST(@RequestBody APIUserJoinDTO apiUserJoinDTO, RedirectAttributes redirectAttributes) {
        log.info("join post..........");
        log.info(apiUserJoinDTO);

        try {
            // 비밀번호를 BCrypt로 해싱
            String hashedPassword = new BCryptPasswordEncoder().encode(apiUserJoinDTO.getPassword());
            apiUserJoinDTO.setPassword(hashedPassword);
            //회원가입 서비스 실행
            memberService.join(apiUserJoinDTO);
            //아이디가 존재 할 경우 에러 발생
        } catch (MemberService.MidExistException e) {
            //에러 발생시 리다이렉트 페이지에 error=mid 값을 가지고 이동
            redirectAttributes.addFlashAttribute("error", "mid");
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/";
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        log.info("logout..........");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/modify/{mid}")
    public ResponseEntity<APIUserJoinDTO> getUserByMid(@PathVariable("mid") String mid) {
        log.info("Fetching user info for mid: " + mid);
        APIUserJoinDTO apiUserJoinDTO = memberService.getUserByMid(mid);
        return ResponseEntity.ok(apiUserJoinDTO);
    }
    @PostMapping("/modify/{mid}")
    public String modifyPOST(@RequestBody APIUserJoinDTO apiUserJoinDTO){
        log.info("modify post...........");
        memberService.modify(apiUserJoinDTO);
        return "/";
    }
    @DeleteMapping("/delete/{mid}")
    public ResponseEntity<String> deleteUserByMid(@PathVariable("mid") String mid) {
        log.info("Deleting user with mid: " + mid);
        memberService.deleteUserByMid(mid);
        return ResponseEntity.ok("User deleted successfully");
    }

}
