package unicornfinder.unicornfinder.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.Interest;
import unicornfinder.unicornfinder.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    /** memberId와 companyId가 interest db에 있는지 확인*/
    /** null 일수도 있으므로 optional로 */
    public Optional<Interest> findInterestByMemberCompany(Long memberId, Long companyId){
        List<Interest> interests = em.createQuery("select i from Interest i " +
                        "where i.company.id = :companyId and i.member.id = :memberId", Interest.class)
                .setParameter("companyId", companyId)
                .setParameter("memberId", memberId)
                .getResultList();
        return interests.stream().findAny();
    }

    //나중에 memberId를 기준으로 조회할때 쓸거같다.
    public List<Interest> findAllByMember(Long memberId){
        return em.createQuery("select i from Interest i where i.member.id = :memberId", Interest.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    //나중에 companyId를 기준으로 조회할때 쓸거같다.
    public List<Interest> findAllByCompany(Long companyId){
        return em.createQuery("select i from Interest i where i.company.id = :companyId", Interest.class)
                .setParameter("companyId", companyId)
                .getResultList();
    }

    public void delete (Long id){
        Interest interest = findOne(id);
        em.remove(interest);
    }
}
