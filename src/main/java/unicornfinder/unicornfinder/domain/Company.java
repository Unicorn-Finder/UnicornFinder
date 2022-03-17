package unicornfinder.unicornfinder.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Company extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    private String name; // 회사명

    private String product; // 서비스 명
    private int invest; // 총 투자액

    @Enumerated(EnumType.STRING)
    private Round round; // 투자 단계

    private String domain; // 서비스 분야
    private int employee; // 직원 수

    @Enumerated(EnumType.STRING)
    private Location location; // 위치

    private int count; //관심수

    private String register_id; // 등록한 사람
    private String update_id; // 수정한 사람

    public void setCount(int count) {
        this.count = count;
    }
}
