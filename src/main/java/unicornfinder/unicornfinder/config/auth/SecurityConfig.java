package unicornfinder.unicornfinder.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import unicornfinder.unicornfinder.domain.Role;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들 활성화 시켜준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()//h2-console 화면 사용을 위해 해당 옵션 disable
                .and()
                .authorizeRequests()// URL 별 권한 관리 설정하는 옵션 시작점, 이게 선언되야 antMatchers 사용 가능
                // 권한 관리 대상을 지정하는 옵션, URL HTTP 메소드 별로 관리 가능,
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.ADMIN.name())//해당 URL admin에게만 개방
                .anyRequest().authenticated() // 이외 나머지 URL은 인증된 사용자들에게 허용
                .and()
                .logout()// 로그아웃 기능에대한 설정 진입점
                .logoutSuccessUrl("/")// 로그아웃 성공시 / 로 간다.
                .and()
                .oauth2Login()//OAuth2 로그인 기능에대한 설정 진입점
                .userInfoEndpoint()// OAuth2 로그인 성공 이후 사용자 정보를 가져올때의 설정들을 담당함
                .userService(customOAuth2UserService);// 로그인 성공시 후속 조치 진행할 UserService 인터페이스의 구현체 등록, 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하는 기능을 명시할수있다.
    }
}
