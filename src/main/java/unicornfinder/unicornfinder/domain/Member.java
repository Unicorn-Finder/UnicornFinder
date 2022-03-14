package unicornfinder.unicornfinder.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role; //관리자, 일반사용자 구분(ADMIN, USER)

    @OneToMany(mappedBy = "memberId")
    private List<Interest> interests;

    // 생성자
    @Builder
    public Member(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Member update(String name) {
        log.info("update name");
        this.name = name;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}


