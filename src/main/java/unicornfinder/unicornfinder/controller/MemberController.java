package unicornfinder.unicornfinder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import unicornfinder.unicornfinder.config.auth.dto.SessionMember;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.Member;
import unicornfinder.unicornfinder.service.CompanyService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final HttpSession httpSession;

    private final CompanyService companyService;

    @GetMapping("/")
    public String index(Model model) {
        // CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser 저장
        // 로그인 성공시 httpSession에서 값 가져옴
        SessionMember member = (SessionMember) httpSession.getAttribute("member");
        if (member != null) {
            model.addAttribute("memberName", member.getName());
        }

        //Company 전체 검색
        List<Company> companies = companyService.findCompanies();
        model.addAttribute("companies", companies);
        return "index";
    }
}
