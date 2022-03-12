package unicornfinder.unicornfinder.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Interest {

    @Id @GeneratedValue
    @Column(name = "interest_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company companyId;
}
