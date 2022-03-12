package unicornfinder.unicornfinder.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Stage {

    @Id @GeneratedValue
    @Column(name = "stage_id")
    private Long id;

    @Column(name = "stage_name")
    private String name; //투자 단계 명

    private int invest; // 투자액
}
