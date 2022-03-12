package unicornfinder.unicornfinder.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Invest {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    //date로 할지 고민,, 년도만 할거니까..?
    private String year;

    private int invest;//투자액
}
