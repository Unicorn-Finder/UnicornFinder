package unicornfinder.unicornfinder.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.controller.CompanyDetailForm;
import unicornfinder.unicornfinder.controller.CompanyForm;
import unicornfinder.unicornfinder.domain.*;
import unicornfinder.unicornfinder.repository.CompanyDetailRepository;
import unicornfinder.unicornfinder.repository.CompanyRepository;
import unicornfinder.unicornfinder.repository.InterestRepository;
import unicornfinder.unicornfinder.repository.MemberRepository;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class CompanyDetailServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired CompanyDetailService companyDetailService;
    @Autowired CompanyDetailRepository companyDetailRepository;
    @Autowired InterestRepository interestRepository;
    @Autowired InterestService interestService;
    @Autowired CompanyService companyService;
    @Autowired CompanyRepository companyRepository;
    @Autowired EntityManager em;


    @AfterEach
    void cleanup(){
        System.out.println("---- cleanup -----");
        companyService.deleteAll();
    }

    @Test
    void 회사상세조회()  throws Exception{
        //given
        CompanyForm companyForm = createForm(20, "80000000", "스프링", "스프링파인더");
        //when
        Company company = Company.createCompany(companyForm);
        Long id = companyService.create(company);
        em.flush();
        //then
        Assertions.assertThat(company.getCompanyDetail()).isEqualTo(companyService.findOne(id).getCompanyDetail());
    }

    @Test
    void 회사상세수정() {
        //given
        CompanyForm companyForm = createForm(30, "40000000", "유니콘", "유니콘파인더");
        Company company = Company.createCompany(companyForm);
        Long id = companyService.create(company);

        CompanyDetailForm detailForm = createDetailForm("www.bm.com", "최근에 투자받음", "서울시 송파구 xx", "이기업은 ~", "재택근무");
        //when
        companyDetailService.updateCompanyDetail(id, detailForm);
        //then
        Assertions.assertThat(companyService.findOne(id).getCompanyDetail().getBlog()).isEqualTo("www.bm.com");
    }

    @Test
    void 관심등록(){
        //given
        Member member = new Member("재형", "jh@gmail.com", Role.ADMIN);
        memberRepository.save(member);

        Member member1 = new Member("aaa", "jh@gmail.com", Role.ADMIN);
        memberRepository.save(member1);

        Member member2 = new Member("bbb", "jh@gmail.com", Role.ADMIN);
        memberRepository.save(member2);

        CompanyForm companyForm = createForm(30, "40000000", "유니콘", "유니콘파인더");
        Company company = Company.createCompany(companyForm);
        Long createId = companyService.create(company);
        //when
        Long id = interestService.interest(member.getId(), createId);
        System.out.println(company.getCount());

        interestService.interest(member1.getId(), createId);
        System.out.println(company.getCount());

        interestService.interest(member2.getId(), createId);
        System.out.println(company.getCount());
    }

    private CompanyDetailForm createDetailForm(String blog, String etc, String location, String info, String welfare) {
        CompanyDetailForm companyDetailForm = new CompanyDetailForm();
        companyDetailForm.setBlog(blog);
        companyDetailForm.setEtc(etc);
        companyDetailForm.setLocation(location);
        companyDetailForm.setInfo(info);
        companyDetailForm.setWelfare(welfare);
        return companyDetailForm;
    }

    private CompanyForm createForm(int employee, String invest, String name, String product) {
        CompanyForm companyForm = new CompanyForm();
        companyForm.setEmployee(employee);
        companyForm.setInvest(invest);
        companyForm.setName(name);
        companyForm.setProduct(product);
        return companyForm;
    }


}