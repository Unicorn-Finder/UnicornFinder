package unicornfinder.unicornfinder.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.repository.CompanyRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@SpringBootTest
@Transactional
class CompanyServiceTest {

    @Autowired CompanyService companyService;
    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void 전체조회() throws Exception{
        List<Company> companyList= companyService.findCompanies();
        for(Company c : companyList)
            System.out.println("count : "+c.getCount()+" "+
                    "id : "+c.getId()+" "+
                    "name : "+c.getName()+" ");
    }
}