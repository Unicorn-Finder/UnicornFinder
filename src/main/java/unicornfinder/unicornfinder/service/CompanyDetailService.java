package unicornfinder.unicornfinder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.controller.CompanyDetailForm;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.CompanyDetail;
import unicornfinder.unicornfinder.domain.Interest;
import unicornfinder.unicornfinder.domain.Member;
import unicornfinder.unicornfinder.repository.CompanyDetailRepository;
import unicornfinder.unicornfinder.repository.CompanyRepository;
import unicornfinder.unicornfinder.repository.MemberRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CompanyDetailService {

    private final CompanyDetailRepository companyDetailRepository;
    private final CompanyRepository companyRepository;

    //필요없을듯, 생성안하고 update만 하므로
    public void saveCompanyDetail(CompanyDetail cd){
        companyDetailRepository.save(cd);
    }
    /** info 추가*/ /** chanegeDetail에 인자넣는 부분 어색하다*/
    public void updateCompanyDetail(Long companyId, CompanyDetailForm companyDetailForm){
        Long id = companyRepository.findOne(companyId).getCompanyDetail().getId(); /**이렇게 수동으로 넣어주어야하나?*/
        CompanyDetail cd = companyDetailRepository.findOne(id);
        cd.changeDetail(companyDetailForm.getInfo(), companyDetailForm.getBlog(), companyDetailForm.getWelfare(), companyDetailForm.getEtc(), companyDetailForm.getLocation());
    }

    public CompanyDetail findOne(Long id){
        return companyDetailRepository.findOne(id);
    }


}