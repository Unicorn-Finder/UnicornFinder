package unicornfinder.unicornfinder.config.auth.dto;

import lombok.Getter;
import unicornfinder.unicornfinder.domain.Member;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }
}