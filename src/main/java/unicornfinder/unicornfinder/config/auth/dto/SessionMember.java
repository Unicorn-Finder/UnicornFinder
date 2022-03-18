package unicornfinder.unicornfinder.config.auth.dto;

import lombok.Getter;
import unicornfinder.unicornfinder.domain.Member;
import unicornfinder.unicornfinder.domain.Role;

import java.io.Serializable;

@Getter
//Serializable로 직렬화를 구현했다.
public class SessionMember implements Serializable {
    private String name;
    private String email;
    //session에 role 추가(관리자인지 알아보기 위해)
    private Role role;

    public SessionMember(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.role = member.getRole();
    }
}