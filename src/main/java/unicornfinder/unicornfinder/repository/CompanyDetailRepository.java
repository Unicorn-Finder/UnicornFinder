package unicornfinder.unicornfinder.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import unicornfinder.unicornfinder.domain.CompanyDetail;

import javax.persistence.EntityManager;

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

    public CompanyDetail findOne(Long id){
        return em.find(CompanyDetail.class, id);
    }

    /** test 를 위한 메서드 다시 구현 필요*/
    //아직 정확하지않음
    public void deleteAll(){
        em.flush();
        em.clear();
    }
}
