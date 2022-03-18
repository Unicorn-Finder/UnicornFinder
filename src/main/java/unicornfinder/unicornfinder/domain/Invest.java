package unicornfinder.unicornfinder.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class Invest {
    @Id @GeneratedValue
    @Column(name = "invest_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    //date로 할지 고민,, 년도만 할거니까..?
    private String year;

    private long invest;//투자액
}
