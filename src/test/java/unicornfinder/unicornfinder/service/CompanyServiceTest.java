package unicornfinder.unicornfinder.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.Interest;
import unicornfinder.unicornfinder.domain.Member;
import unicornfinder.unicornfinder.repository.CompanyRepository;

import javax.persistence.criteria.CriteriaBuilder;
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
        /*//컴퍼니 저장 메소드 호출
        Company company = saveCompany();
        //테스트용 interest 저장
        Interest interest = new Interest();

        interest.setCompanyId(company);

        companyRepository.saveInterest(interest);

        Interest interest2 = new Interest();

        interest2.setCompanyId(company);

        companyRepository.saveInterest(interest2);
*/
        List<Company> companyList= companyService.findCompanies();
        for(Company c : companyList)
            System.out.println("count : "+c.getCount()+" "+
                    "id : "+c.getId()+" "+
                    "name : "+c.getName()+" ");
    }

   /* private Company saveCompany(){
        //테스트용 company 저장
        Company company = new Company();

        company.setName("우아한형제들");
        company.setProduct("배달의민족");

        companyRepository.save(company);

        return company;
    }*/

    @Test
    public void 검색(){
/*

        Company company = saveCompany();

        //테스트용 interest 저장
        Interest interest = new Interest();

        interest.setCompanyId(company);

        companyRepository.saveInterest(interest);

        Interest interest2 = new Interest();

        interest2.setCompanyId(company);

        companyRepository.saveInterest(interest2);
*/

        List<Company> companyList= companyService.searchCompanies("우아한");
        if(companyList.isEmpty()){
            System.out.println("================================================");
            System.out.println("조회결과 0");
        }
        for(Company c : companyList)
            System.out.println("count : "+c.getCount()+" "+
                    "id : "+c.getId()+" "+
                    "name : "+c.getName()+" ");
    }

    @Test
    public void 저장(){
        Company company = new Company();
        company.setName("우아한 형제들");
        company.setProduct("배달의 민족");
        companyService.saveCompany(company);
    }
}