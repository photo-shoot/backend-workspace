package photoshoot.backendworkspace.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import photoshoot.backendworkspace.dto.refreshToken.RefreshTokenResponseDTO;
import photoshoot.backendworkspace.entity.RefreshToken;
import photoshoot.backendworkspace.exception.PictainException;
import photoshoot.backendworkspace.repository.RefreshTokenRepository;
import photoshoot.backendworkspace.security.CookieProperties;
import photoshoot.backendworkspace.security.CookieUtil;
import photoshoot.backendworkspace.security.JwtProperties;

import java.util.Date;

public class JwtService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;
    @Autowired
    CookieUtil cookieUtil;

    public String createAccessToken(Long id, String email, String nickName, String type){
        String token = JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.ACCESS_EXPIRATION_TIME)) // 토큰만료시간
                .withIssuedAt(new Date()) // 토큰발급시간
                .withSubject(email)
                .withClaim("id", id)
                .withClaim("email", email)
                .withClaim("nickname", nickName)
                .withClaim("type", type)
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));
        return token;
    }

    public String createRefreshToken(Long id, String email, String nickName, String type){
        String token = JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.REFRESH_EXPIRATION_TIME)) // 토큰만료시간
                .withIssuedAt(new Date()) // 토큰발급시간
                .withSubject(email)
                .withClaim("id", id)
                .withClaim("email", email)
                .withClaim("nickname", nickName)
                .withClaim("type", type)
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));
        return token;
    }

    public void reCreateRefreshToken(Cookie refreshCookie, HttpServletResponse response){
        // refresh 토큰 만료 체크. 만료되었다면? 로그아웃 요청
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(refreshCookie.getValue());
        Long id = decodedJWT.getClaim("id").asLong();
        String email = decodedJWT.getClaim("email").asString().toString();
        String nickname = decodedJWT.getClaim("nickname").asString().toString();
        String type = decodedJWT.getClaim("type").asString().toString();
        if(decodedJWT.getClaim("email") == null) throw new PictainException("refresh token이 유효하지 않습니다. 로그아웃처리 해주세요", HttpStatus.UNAUTHORIZED);
        // refresh 토큰 만료되지 않았다면, 새로운 accessToken을 발급해준다.
        String newAccessToken = createAccessToken(id, email, nickname, type);
        // !추후에 redis 적용하면 바뀔 수 있다.~~~ RTR 쓸거니깐!! access token 새로 발급 받을 때 refresh token도 새롭게 발급 받아주기! 담에 ~ ㅎ
        // refresh 쿠키 다시
        response.addCookie(refreshCookie);
        // 헤더에 access token 넣기
        response.addHeader(JwtProperties.ACCESS_TOKEN_HEADER, JwtProperties.ACCESS_TOKEN_HEADER + newAccessToken);
        // refresh token 쿠키 추가!

    }

    public RefreshTokenResponseDTO saveRefreshTokenToDB(String token, Long userId, String email, String nickname){
        String id;
        System.out.println("refresh토큰이 데이터베이스에 저장됩니댜...");
        // RefreshToken Entity로 변환
        RefreshToken entity = RefreshToken.toEntity(token, userId, email, nickname);
        RefreshTokenResponseDTO dto = RefreshTokenResponseDTO.toDTO(refreshTokenRepository.save(entity));
        return dto;
    }
}
