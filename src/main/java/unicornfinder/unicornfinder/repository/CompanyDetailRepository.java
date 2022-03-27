package unicornfinder.unicornfinder.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.CompanyDetail;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyDetailRepository {

    private final EntityManager em;

    public void save(CompanyDetail cd){ //수정을 위한 체크
        if (cd.getId() == null){
            em.persist(cd);
        } else {
            em.merge(cd);
        }
    }

    //companyDetail 전체 조회
    public List<CompanyDetail> findAll(){
        List<CompanyDetail> details = em.createQuery("select d from CompanyDetail d", CompanyDetail.class)
                .getResultList();
        return details;
    }

    public CompanyDetail findOne(Long id){
        return em.find(CompanyDetail.class, id);
    }

    /** 고아 객체 제거를 사용해 제거*/
//    public void delete (Long id){
//        CompanyDetail companyDetail = findOne(id);
//        em.remove(companyDetail);
//    }
//
//    /** test 를 위한 메서드 다시 구현 필요*/
//    //아직 정확하지않음
//    public void deleteAll(){
//        List<CompanyDetail> details = findAll();
//        for (CompanyDetail detail : details) {
//            delete(detail.getId());
//        }
//    }
}
