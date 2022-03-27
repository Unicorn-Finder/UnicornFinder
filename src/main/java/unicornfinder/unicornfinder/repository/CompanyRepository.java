package unicornfinder.unicornfinder.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.Interest;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class CompanyRepository {

    private final EntityManager em;

    public void save(Company company){
        if(company.getId()==null) {
            em.persist(company);
        }
        else{
            em.merge(company);
        }
    }

    public Company findOne(Long id) {
        return em.find(Company.class, id);
    }
    //company 전체 조회
    public List<Company> findAll(){
        List<Company> companyList = em.createQuery("select c from Company c", Company.class)
                .getResultList();
        //조회한 company에 count값 설정해주기
        for(Company c : companyList){
            c.setCount(findCountById(c.getId()));
        }
        return companyList;
    }

    //company count 값 설정  findCountById
    private int findCountById(Long id) {
        List<Interest> interests = em.createQuery("select i from Interest i " +
                "where i.company.id = :companyid", Interest.class)
                .setParameter("companyid", id)
                .getResultList();
        return interests.size();
    }

    //회사이름이나 서비스명 검색하기
    // !프런트에서 작업해도 될거같지만 일단 리포지토리를 만들어봤음
    public List<Company> findByName_Product(String search){

        List<Company> companyList = em.createQuery("select c from Company c " +
                "where c.name like :search or c.product like :search", Company.class)
                .setParameter("search", "%"+search+"%")
                .getResultList();

        //조회한 company에 count값 설정해주기
        for(Company c : companyList){
            c.setCount(findCountById(c.getId()));
        }

        return companyList;
    }

//    public void delete (Long id){
//        Company company = findOne(id);
//        em.remove(company);
//    }

    /** test 를 위한 메서드*/
    public void deleteAll(){
        em.flush();
        em.clear();
    }
}
