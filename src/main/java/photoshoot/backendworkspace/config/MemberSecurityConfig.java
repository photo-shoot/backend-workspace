package photoshoot.backendworkspace.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import photoshoot.backendworkspace.security.CookieUtil;
import photoshoot.backendworkspace.security.PictainAuthenticationFilter;
import photoshoot.backendworkspace.security.PictainAuthenticationProvider;
import photoshoot.backendworkspace.service.JwtService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MemberSecurityConfig {

    private final AuthenticationConfiguration authConfiguration;
    @Autowired
    private AuthenticationManagerBuilder authManagerBuilder;

    @Bean
    public CookieUtil cookieUtil(){
        return new CookieUtil();
    }

    @Bean
    public JwtService jwtService(){return new JwtService();}

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("MemberSecurity filterchain 실행됨");
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .addFilter(new PictainAuthenticationFilter(authenticationManager(), authManagerBuilder, jwtService(), cookieUtil()))
                .authorizeHttpRequests()
                .requestMatchers("/**")
                .permitAll();
        return http.build();
    }

}
