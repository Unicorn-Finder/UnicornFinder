package unicornfinder.unicornfinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.CompanyDetail;
import unicornfinder.unicornfinder.domain.Interest;
import unicornfinder.unicornfinder.domain.Member;
import unicornfinder.unicornfinder.repository.CompanyDetailRepository;
import unicornfinder.unicornfinder.repository.CompanyRepository;
import unicornfinder.unicornfinder.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyDetailService {

    private final CompanyDetailRepository cdRepository;

    //필요없을듯, 생성안하고 update만 하므로
    public void saveCompanyDetail(CompanyDetail cd){
        cdRepository.save(cd);
    }

    public void updateCompanyDetail(Long id, String blog, String welfare, String etc, String location){
        CompanyDetail cd = cdRepository.findOne(id);
        cd.changeDetail(blog, welfare, etc, location);
    }

    public CompanyDetail findOne(Long id){
        return cdRepository.findOne(id);
    }


}