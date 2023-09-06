package photoshoot.backendworkspace.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import photoshoot.backendworkspace.security.CookieUtil;
import photoshoot.backendworkspace.service.JwtService;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private CookieUtil cookieUtil;

    @GetMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response){
        Cookie refreshCookie = cookieUtil.getRefreshTokenFromCookie(request);
        jwtService.reCreateRefreshToken(refreshCookie, response);
    }

}
