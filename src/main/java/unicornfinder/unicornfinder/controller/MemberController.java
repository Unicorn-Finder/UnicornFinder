package unicornfinder.unicornfinder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unicornfinder.unicornfinder.config.auth.dto.SessionUser;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        SessionUser member = (SessionUser) httpSession.getAttribute("user"); //?
        if (member != null) {
            model.addAttribute("memberName", member.getName());
        }
        return "index";
    }
}
