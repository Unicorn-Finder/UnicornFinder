package unicornfinder.unicornfinder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import unicornfinder.unicornfinder.service.CompanyService;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/companies/new")
    public String companyForm(){
        return "companies/companyForm";
    }
}
