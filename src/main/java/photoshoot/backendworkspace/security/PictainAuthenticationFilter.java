package photoshoot.backendworkspace.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import photoshoot.backendworkspace.dto.sign.SigninRequestDTO;
import photoshoot.backendworkspace.exception.PictainException;
import photoshoot.backendworkspace.service.JwtService;

import java.io.IOException;
import java.util.Base64;

// 로그인할 때 실행되는 필터
@Slf4j
public class PictainAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private PictainAuthenticationProvider authenticationProvider;

    CookieUtil cookieUtil;
    JwtService jwtService;
    AuthenticationManager authenticationManager;

    public PictainAuthenticationFilter(AuthenticationManager manager, AuthenticationManagerBuilder managerBuilder, JwtService jwtService, CookieUtil cookieUtil){
        this.jwtService = jwtService;
        this.cookieUtil = cookieUtil;
        this.authenticationManager = manager;
        managerBuilder.authenticationProvider(authenticationProvider);
        setFilterProcessesUrl("/signin");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException  {
        try{
            System.out.println("로그인 시도중입니다.");
            ObjectMapper objectMapper = new ObjectMapper();
            SigninRequestDTO dto = objectMapper.readValue(request.getInputStream(), SigninRequestDTO.class);
            String email = dto.getEmail();
            String password = dto.getPassword();
            String type = dto.getType();
            // 아직 인증되지 않은 authentication
            // 참고로 UsernamePasswordAuthenticationToken는 authentication을 상속받음.
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
            if(type.equals("MEMBER")) authenticationToken.setDetails(new MemberDetails());
            else if(type.equals("ADMIN")) authenticationToken.setDetails(new AdminDetails());
            else throw new PictainException("유효하지 않은 type입니다.", HttpStatus.BAD_REQUEST);
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        Long id;
        String email;
        String nickname;
        String type;

        if(authResult.getDetails() instanceof MemberDetails){
            MemberDetails details = (MemberDetails)authResult.getDetails();
            nickname = details.getNickname();
            email = details.getEmail();
            id = details.getId();
            type = details.getType();
        }else{
            AdminDetails details = (AdminDetails)authResult.getDetails();
            nickname = details.getNickname();
            email = details.getEmail();
            id = details.getId();
            type = details.getType();
        }

        // 쿠키 넘기기
        String accessToken = jwtService.createAccessToken(id, email, nickname, type);
        String refreshToken = jwtService.createRefreshToken(id, email, nickname, type);
        //redis 구축된 후에 refresh token을 db에 저장하자!
        //RefreshTokenResponseDTO refreshTokenResponseDTO = jwtUtil.saveRefreshTokenToDB(refreshToken, id, email, type); // refresh token의 db 아이디 넘기기 - 나중쓰!!
        // 일단 refresh token은 쿠키에 담기
        Cookie refreshCookie = cookieUtil.createCookie(CookieProperties.REFRESH_TOKEN_COOKIE_NAME, refreshToken);
        response.addCookie(refreshCookie);
        response.addHeader(JwtProperties.ACCESS_TOKEN_HEADER, JwtProperties.TOKEN_PREFIX + accessToken);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("access token 발급되었습니다. header 확인하세요");
        System.out.println("토큰발급 되었어용");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        System.out.println("authentication 실패!");
        super.unsuccessfulAuthentication(request, response, failed);
    }

}
