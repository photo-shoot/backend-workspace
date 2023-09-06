package photoshoot.backendworkspace.security;

import org.springframework.beans.factory.annotation.Value;

public interface JwtProperties {
    @Value("${JWT_SECRET}")
    String SECRET = "test_secret";
    int REFRESH_EXPIRATION_TIME = 1000*60*60*24*14; // 14일(2주)
    int ACCESS_EXPIRATION_TIME = 1000*60*30; // 30분
    String TOKEN_PREFIX = "Bearer ";
    String ACCESS_TOKEN_HEADER = "Authorization";
}
