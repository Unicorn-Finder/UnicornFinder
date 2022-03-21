package unicornfinder.unicornfinder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unicornfinder.unicornfinder.config.auth.dto.SessionMember;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.CompanyDetail;
import unicornfinder.unicornfinder.domain.Member;
import unicornfinder.unicornfinder.repository.MemberRepository;
import unicornfinder.unicornfinder.service.CompanyDetailService;
import unicornfinder.unicornfinder.service.CompanyService;
import unicornfinder.unicornfinder.service.InterestService;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CompanyDetailController {

    private final HttpSession httpSession;
    private final CompanyDetailService companyDetailService;
    private final CompanyService companyService;
    private final InterestService interestService;
    private final MemberRepository memberRepository;

    @GetMapping("/companies/{companyId}") /** interest 유무도 체크*/
    public String detail(@PathVariable Long companyId, Model model){

        Company company = companyService.findOne(companyId);
        CompanyDetail companyDetail = companyDetailService.findOne(company.getCompanyDetail().getId()); //이부분 지져분하다

        SessionMember sessionMember = (SessionMember) httpSession.getAttribute("member");
        Long memberId = memberRepository.findByEmail(sessionMember.getEmail()).get().getId();

        int status = interestService.checkInterest(memberId, companyId);

        model.addAttribute("memberId", memberId);/** 멤버 아이디 추가*/
        model.addAttribute("status", status); /** interest 유무 파악을 위한 member*/
        model.addAttribute("companyDetail", companyDetail);
        model.addAttribute("company", company);
        return "companies/companyDetail";
    }

    @PostMapping("/interest/{memberId}/{companyId}/cancel")
    public String cancelInterest(@PathVariable Long memberId, @PathVariable Long companyId){
        interestService.cancelInterest(memberId, companyId);
        return "redirect:/companies/{companyId}";
    }

    @PostMapping("/interest/{memberId}/{companyId}")
    public String interest(@PathVariable Long memberId, @PathVariable Long companyId){
        interestService.interest(memberId, companyId);
        return "redirect:/companies/{companyId}";
    }


}
