package unicornfinder.unicornfinder.config.auth.dto;

import lombok.Getter;
import unicornfinder.unicornfinder.domain.Member;

import java.io.Serializable;

@Getter
//Serializable로 직렬화를 구현했다.
public class SessionMember implements Serializable {
    private String name;
    private String email;

    public SessionMember(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }
}