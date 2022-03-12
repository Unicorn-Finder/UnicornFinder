package unicornfinder.unicornfinder.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "company_detail")
public class CompanyDetail {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String blog;//기술블로그

    private  String welfare;//직원복지

    private  String etc;//기타사항

}
