package photoshoot.backendworkspace.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import photoshoot.backendworkspace.dto.refreshToken.RefreshTokenResponseDTO;
import photoshoot.backendworkspace.exception.PictainException;

public class CookieUtil {

    public Cookie createCookie(String key, String token){
        Cookie cookie = new Cookie(key, token);
        //cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setDomain(CookieProperties.COOKIES_DOMAIN);
        return cookie;
    }

    public Cookie getRefreshTokenFromCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(CookieProperties.REFRESH_TOKEN_COOKIE_NAME)){
                return cookie;
            }
        }
        throw new PictainException("refresh 관련 쿠키를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST);
    }

}

