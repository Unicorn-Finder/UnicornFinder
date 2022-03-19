package unicornfinder.unicornfinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.repository.CompanyRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Long create(Company company){
        companyRepository.save(company);
        return company.getId();
    }

    public Company findOne(Long id){
        return companyRepository.findOne(id);
    }

}
