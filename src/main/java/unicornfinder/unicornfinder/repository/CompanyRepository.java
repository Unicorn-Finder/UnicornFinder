package unicornfinder.unicornfinder.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import unicornfinder.unicornfinder.domain.Company;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CompanyRepository {

    private final EntityManager em;

    public void save(Company company){
        em.persist(company);
    }

    public Company findOne(Long id){
        return em.find(Company.class, id);
    }
}
