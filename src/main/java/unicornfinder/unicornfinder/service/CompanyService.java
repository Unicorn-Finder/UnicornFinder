package unicornfinder.unicornfinder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.Interest;
import unicornfinder.unicornfinder.repository.CompanyRepository;
import unicornfinder.unicornfinder.repository.InterestRepository;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final InterestRepository interestRepository;

    @Transactional
    public Long create(Company company){
        companyRepository.save(company);
        return company.getId();
    }

    public Company findOne(Long id){
        return companyRepository.findOne(id);
    }

    //company 전체 조회
    public List<Company> findCompanies(){
        return companyRepository.findAll();
    }

    //검색 기능(name, product 와 일치하는 항목 가져오기)
    public List<Company> searchCompanies(String search){
        return companyRepository.findByName_Product(search);
    }

    @Transactional
    public void delete (Long companyId){
        companyRepository.delete(companyId);
        List<Interest> interests = interestRepository.findAllByCompany(companyId);
        log.warn(interests.toString());
        if (!interests.isEmpty()){
            for (Interest interest : interests) {
                interestRepository.delete(interest.getId());
            }
        }
    }

    @Transactional
    public void deleteAll (){
        companyRepository.deleteAll();
    }
}
