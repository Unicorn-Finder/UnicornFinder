package unicornfinder.unicornfinder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import unicornfinder.unicornfinder.config.auth.dto.SessionMember;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.service.CompanyService;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

    private final HttpSession httpSession;

    private final CompanyService companyService;

    /** model에 companyForm 담아서 보내주기*/
    @GetMapping("/companies/new")
    public String companyForm(Model model){
        //session의 role이 admin이 메인페이지로 이동
        SessionMember member = (SessionMember) httpSession.getAttribute("member");

        if(member.getRole().toString().equals("ADMIN")){
            return "companies/companyForm";
        }
        else{
            return "redirect:/";
        }
    }

    /** createCompany로 company 생성*/
    @PostMapping("/companies/new")
    public String companySave(CompanyForm companyform){
//        Company company = new Company();
//
//        System.out.println(companyform.getName());
//
//        company.setName(companyform.getName());
//        company.setEmployee(companyform.getEmployee());
//        company.setProduct(companyform.getProduct());
//        company.setDomain(companyform.getDomain());
//        company.setInvest(companyform.getInvest());
//        company.setLocation(companyform.getLocation());
//        company.setRound(companyform.getRound());
//
//        companyService.saveCompany(company);
        Company company = Company.createCompany(companyform);

        companyService.create(company);

        return "redirect:/";
    }
}
