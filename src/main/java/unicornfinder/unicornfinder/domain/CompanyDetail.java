package unicornfinder.unicornfinder.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "company_detail")
public class CompanyDetail {
    @Id @GeneratedValue
    @Column(name = "detail_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private String blog;//기술블로그

    private  String welfare;//직원복지

    private  String etc;//기타사항

}
