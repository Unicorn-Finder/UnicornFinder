package unicornfinder.unicornfinder.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Interest {

    @Id @GeneratedValue
    @Column(name = "interest_id")
    private Long id;

    /** 변수명 변경 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;


    public void setInterest(Member member, Company company){ //변수명이 좀 이상하다.
        this.member = member;
        this.company = company;
    }

    //비즈니스 로직
    public static Interest register(Member member, Company company){
        Interest interest = new Interest();
        interest.setInterest(member, company);

        interest.getCompany().addInterest();
        return interest;
    }

    public void cancel(){
        this.getCompany().removeInterest();
    }
}
