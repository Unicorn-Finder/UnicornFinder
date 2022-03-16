package unicornfinder.unicornfinder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unicornfinder.unicornfinder.config.auth.dto.SessionMember;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        // CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser 저장
        // 로그인 성공시 httpSession에서 값 가져옴
        SessionMember member = (SessionMember) httpSession.getAttribute("member");
        if (member != null) {
            model.addAttribute("memberName", member.getName());
        }
        return "index";
    }
}
