package unicornfinder.unicornfinder.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserType role; //관리자, 일반사용자 구분(ADMIN, USER)

    //유재형이랑 합치면 클래스 임포트 할것
    private List<Interest> interests;
}


