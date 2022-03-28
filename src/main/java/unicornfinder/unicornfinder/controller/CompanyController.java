package unicornfinder.unicornfinder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
            CompanyForm companyForm = new CompanyForm();
            model.addAttribute("companyForm", companyForm);
            return "companies/companyForm";
        }
        else{
            return "redirect:/";
        }
    }

    /** createCompany로 company 생성*/
    @PostMapping("/companies/new")
    public String companySave(CompanyForm companyform){
        Company company = Company.createCompany(companyform);
        
      //수정 위해서 추가
        if(companyform.getId()!=null){
            company.setId(companyform.getId());
        }
      
        companyService.create(company);

        return "redirect:/";
    }

    @GetMapping("/companies/{companyId}/editCompany")
    public String updateForm(@PathVariable Long companyId,  Model model){
        CompanyForm companyForm = new CompanyForm();

        Company company = companyService.findOne(companyId);

        companyForm.setId(company.getId());
        companyForm.setDomain(company.getDomain());
        companyForm.setEmployee(company.getEmployee());
        companyForm.setInvest(company.getInvest());
        companyForm.setLocation(company.getLocation());
        companyForm.setName(company.getName());
        companyForm.setProduct(company.getProduct());
        companyForm.setRound(company.getRound());
        companyForm.setCount(company.getCount());


        model.addAttribute("companyForm", companyForm);

        return "companies/companyForm";
    }

    @PostMapping("/companies/{companyId}/editCompany")
    public String updateCompanyDetail(@PathVariable Long companyId, @ModelAttribute CompanyForm companyForm){
        companyService.updateCompany(companyId, companyForm);
        return "redirect:/companies/"+companyId;
    }
}
