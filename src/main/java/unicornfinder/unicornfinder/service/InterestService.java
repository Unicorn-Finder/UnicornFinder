package unicornfinder.unicornfinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unicornfinder.unicornfinder.domain.Company;
import unicornfinder.unicornfinder.domain.Interest;
import unicornfinder.unicornfinder.domain.Member;
import unicornfinder.unicornfinder.repository.CompanyRepository;
import unicornfinder.unicornfinder.repository.InterestRepository;
import unicornfinder.unicornfinder.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class InterestService {

    private final InterestRepository interestRepository;
    private final CompanyRepository companyRepository;
    private final MemberRepository memberRepository;

    //관심등록
    // interest로 이동
    public Long interest(Long memberId, Long companyId){
        //엔티티 조회
        Company company = companyRepository.findOne(companyId);
        Member member = memberRepository.findOne(memberId);

        Interest interest = Interest.register(member, company);
        interestRepository.save(interest);
        return interest.getId();
    }
    //관심해제
    public void cancelInterest(Long memberId, Long companyId){
        Interest interest = interestRepository.findInterestByMemberCompany(memberId, companyId).get();
        Long interestId = interest.getId();

        interest.cancel();
        interestRepository.cancel(interestId);
    }

    //관심인지 유무 체크
    public int checkInterest(Long memberId, Long companyId){
        Interest interest = interestRepository.findInterestByMemberCompany(memberId, companyId).orElse(null);
        if (interest == null)
            return 0;
        return 1;
    }
}
