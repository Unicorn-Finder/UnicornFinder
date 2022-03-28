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

    //companyId로 detailId 찾는 메서드 추가
    public Long findDetailIdByCompanyId(Long companyId) {
        Long detailId = companyRepository.findOne(companyId).getCompanyDetail().getId();
        return detailId;
    }

    //수정 메서드
    public void updateCompanyDetail(Long companyId, CompanyDetailForm companyDetailForm){
        Long id = findDetailIdByCompanyId(companyId);
        CompanyDetail cd = companyDetailRepository.findOne(id);
        cd.changeDetail(companyDetailForm.getInfo(), companyDetailForm.getBlog(), companyDetailForm.getWelfare(), companyDetailForm.getEtc(), companyDetailForm.getLocation());
    }

    public CompanyDetail findOne(Long id){
        return companyDetailRepository.findOne(id);
    }


}