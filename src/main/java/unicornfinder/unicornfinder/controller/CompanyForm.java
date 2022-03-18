package unicornfinder.unicornfinder.controller;

import lombok.Getter;
import lombok.Setter;
import unicornfinder.unicornfinder.domain.Location;
import unicornfinder.unicornfinder.domain.Round;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter @Setter
public class CompanyForm {
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

    private Long id; // 등록한 사람
}
