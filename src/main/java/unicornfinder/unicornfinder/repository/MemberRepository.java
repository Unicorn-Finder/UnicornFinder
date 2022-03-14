package unicornfinder.unicornfinder.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Slf4j
@Repository
@Transactional
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Member save (Member member) {
        em.persist(member);
        return member;
    }

    //회원 id로 검색
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    //전체 회원 검색
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //중복 이메일 검색
    public Optional<Member> findByEmail(String email){
        List<Member> member = em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
        return member.stream().findAny();
    }
}

