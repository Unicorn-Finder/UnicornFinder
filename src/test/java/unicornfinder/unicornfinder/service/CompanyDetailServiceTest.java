package unicornfinder.unicornfinder.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.controller.CompanyForm;
import unicornfinder.unicornfinder.domain.*;
import unicornfinder.unicornfinder.repository.CompanyDetailRepository;
import unicornfinder.unicornfinder.repository.InterestRepository;
import unicornfinder.unicornfinder.repository.MemberRepository;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
@Rollback(value = false)//db 테스트를 위해 롤백 취소
class CompanyDetailServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired CompanyDetailService companyDetailService;
    @Autowired CompanyDetailRepository companyDetailRepository;
    @Autowired InterestRepository interestRepository;
    @Autowired InterestService interestService;
    @Autowired CompanyService companyService;

//    /** createCompany 매개변수 변경에 따라 테스트 부분 변경*/
//    @Test
//    void 회사등록() throws Exception{
//        //given
//        CompanyForm companyForm = new CompanyForm("우아한 형제들", "배달의 민족", 1000000000, Round.SERIES_E, "delivery", 500, Location.SEOUL_SONGPA, 0, null);
//        Company company = Company.createCompany(companyForm);
//        //when
//        Long createId = companyService.create(company);
//        //then
//        Assertions.assertThat(company).isEqualTo(companyService.findOne(createId));
//    }
//
//    @Test
//    void 회사상세조회() throws Exception {
//        //given
//        CompanyForm companyForm = new CompanyForm("우아한 형제들", "배달의 민족", 1000000000, Round.SERIES_E, "delivery", 500, Location.SEOUL_SONGPA, 0, null);
//        Company company = Company.createCompany(companyForm);
//        //when
//        Long createId = companyService.create(company);
//        //then
//        Assertions.assertThat(company.getCompanyDetail()).isEqualTo(companyService.findOne(createId).getCompanyDetail());
//
//    }
//
//    @Test
//    void 회사상세수정() {
//        //given
//        CompanyForm companyForm = new CompanyForm("우아한 형제들", "배달의 민족", 1000000000, Round.SERIES_E, "delivery", 500, Location.SEOUL_SONGPA, 0, null);
//        Company company = Company.createCompany(companyForm);
//        Long createId = companyService.create(company);
//        //when //info 추가
//        companyDetailService.updateCompanyDetail(company.getCompanyDetail().getId(), "이기업은~~","www.bm.com", "맥북 지원", "기술 이사 김영한","서울특별시 송파구 방이2동 위례성대로 2");
//        //then
//        Assertions.assertThat(companyService.findOne(createId).getCompanyDetail().getBlog()).isEqualTo("www.bm.com");
//    }
//
//    @Test
//    void 관심등록(){
//        //given
//        Member member = new Member("재형", "jh@gmail.com", Role.ADMIN);
//        memberRepository.save(member);
//
//        Member member1 = new Member("aaa", "jh@gmail.com", Role.ADMIN);
//        memberRepository.save(member1);
//
//        Member member2 = new Member("bbb", "jh@gmail.com", Role.ADMIN);
//        memberRepository.save(member2);
//
//        CompanyForm companyForm = new CompanyForm("우아한 형제들", "배달의 민족", 1000000000, Round.SERIES_E, "delivery", 500, Location.SEOUL_SONGPA, 0, null);
//        Company company = Company.createCompany(companyForm);
//        Long createId = companyService.create(company);
//        //when
//        Long id = interestService.interest(member.getId(), createId);
//        System.out.println(company.getCount());
//
//        interestService.interest(member1.getId(), createId);
//        System.out.println(company.getCount());
//
//        interestService.interest(member2.getId(), createId);
//        System.out.println(company.getCount());
//
//        interestService.cancelInterest(id);
//        System.out.println(company.getCount());
//        //then
//    }




}