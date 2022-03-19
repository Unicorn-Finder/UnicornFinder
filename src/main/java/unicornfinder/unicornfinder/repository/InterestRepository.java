package unicornfinder.unicornfinder.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.Interest;
import unicornfinder.unicornfinder.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InterestRepository {

    private final EntityManager em;
    private final CompanyRepository companyRepository;
    private final MemberRepository memberRepository;

    public void save(Interest interest){
        em.persist(interest);
    }

    public Interest findOne(Long interestId){
        return em.find(Interest.class, interestId);
    }

    public void cancel(Long id){
        Interest interest = findOne(id);
        em.remove(interest);
    }

    //나중에 memberId를 기준으로 조회할때 쓸거같다.
    public List<Interest> findAllByMember(Long memberId){
        return em.createQuery("select i from Interest i where i.member = :memberId", Interest.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
