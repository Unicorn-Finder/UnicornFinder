package unicornfinder.unicornfinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.repository.CompanyRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor

public class CompanyService {

    private final CompanyRepository companyRepository;

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

    //company저장
    //create 로 변경하기 
    @Transactional
    public Long saveCompany(Company company){
        Company c = companyRepository.saveCompany(company);
        return c.getId();
    }

}
