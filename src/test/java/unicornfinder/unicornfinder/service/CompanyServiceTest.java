//package unicornfinder.unicornfinder.service;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//import unicornfinder.unicornfinder.controller.CompanyForm;
//import unicornfinder.unicornfinder.domain.Company;
//import unicornfinder.unicornfinder.domain.Interest;
//import unicornfinder.unicornfinder.domain.Member;
//import unicornfinder.unicornfinder.repository.CompanyRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.criteria.CriteriaBuilder;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@WebAppConfiguration
//@SpringBootTest
//@Transactional
//class CompanyServiceTest {
//
//    @Autowired CompanyService companyService;
//    @Autowired CompanyRepository companyRepository;
//    @Autowired EntityManager em;
//
//    @AfterEach
//    void cleanup(){
//        System.out.println("---- cleanup -----");
//        companyRepository.deleteAll();
////        List<Company> product = companyRepository.findByName_Product("유니콘파인더");
////        System.out.println(product.size());
//    }
//
//    @Test
//    void 회사등록()  throws Exception{
//        //given
//        CompanyForm companyForm = createForm(30, 40000000, "유니콘", "유니콘파인더");
//        //when
//        Company company = Company.createCompany(companyForm);
//        Long id = companyService.create(company);
//        em.flush();
//
//        //then
//        Assertions.assertThat(company).isEqualTo(companyService.findOne(id));
//    }
//
//    @Test
//    void 회사상세조회()  throws Exception{
//        //given
//        CompanyForm companyForm = createForm(20, 80000000, "스프링", "스프링파인더");
//        //when
//        Company company = Company.createCompany(companyForm);
//        Long id = companyService.create(company);
//        em.flush();
//        //then
//        Assertions.assertThat(company.getCompanyDetail()).isEqualTo(companyService.findOne(id).getCompanyDetail());
//    }
//
//    private CompanyForm createForm(int employee, int invest, String name, String product) {
//        CompanyForm companyForm = new CompanyForm();
//        companyForm.setEmployee(employee);
//        companyForm.setInvest(invest);
//        companyForm.setName(name);
//        companyForm.setProduct(product);
//        return companyForm;
//    }
//
//    @Test
//    public void 전체조회() throws Exception{
//        //given
//        CompanyForm companyForm1 = createForm(30, 40000000, "유니콘", "유니콘파인더");
//        Company company1 = Company.createCompany(companyForm1);
//        companyService.create(company1);
//
//        CompanyForm companyForm2 = createForm(20, 80000000, "스프링", "스프링파인더");
//        Company company2 = Company.createCompany(companyForm2);
//        companyService.create(company2);
//        //when
//        List<Company> companyList= companyService.findCompanies();
//        //then
//        Assertions.assertThat(companyList.size()).isEqualTo(2);
//    }
//}