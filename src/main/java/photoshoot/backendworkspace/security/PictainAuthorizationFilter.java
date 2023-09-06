package photoshoot.backendworkspace.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import photoshoot.backendworkspace.exception.PictainException;
import photoshoot.backendworkspace.service.JwtService;

import java.io.IOException;

@Slf4j
public class PictainAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    JwtService jwtService;

    public PictainAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if(servletPath.equals("/signin") || servletPath.equals("/token")) filterChain.doFilter(request,response);

        String authorizationHeader = request.getHeader(JwtProperties.ACCESS_TOKEN_HEADER);

        // access token 검사
        if(authorizationHeader == null || !authorizationHeader.startsWith(JwtProperties.TOKEN_PREFIX)) throw new PictainException("access token이 존재하지 않습니다.", HttpStatus.BAD_REQUEST);

        try{
            String accessToken = request.getHeader(JwtProperties.ACCESS_TOKEN_HEADER).replace(JwtProperties.TOKEN_PREFIX,"");
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build();

            // token의 claim에서 데이터 꺼내서 Authentication 객체 생성 후 contextholder에 저장
            Long id = jwtVerifier.verify(accessToken).getClaim("id").asLong();
            String email = jwtVerifier.verify(accessToken).getClaim("email").asString();
            String nickname = jwtVerifier.verify(accessToken).getClaim("nickname").asString();
            String type = jwtVerifier.verify(accessToken).getClaim("type").asString();

            UserDetails principal;
            if(type.equals("MEMBER")) principal = new MemberDetails(id, email, nickname);
            else principal = new AdminDetails(id, email, nickname);
            // principal의 권한 가져오는 getAuthorities 어쩌고 이거 다시 체크!! 현재는 null을 반환함.
            Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request,response);
        }
        catch (TokenExpiredException e){
            throw new PictainException("access token이 만료되었습니다.", HttpStatus.UNAUTHORIZED);
        }
        catch (Exception e){
            throw new PictainException("access token이 잘못 되었습니다.", HttpStatus.BAD_REQUEST);
        }

    }


}
