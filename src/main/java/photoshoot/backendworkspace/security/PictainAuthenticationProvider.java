package photoshoot.backendworkspace.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import photoshoot.backendworkspace.exception.PictainException;

@Component
@RequiredArgsConstructor
public class PictainAuthenticationProvider implements AuthenticationProvider {

    private final MemberDetailsService memberDetailsService;
    private final AdminDetailsService adminDetailsService;

    @Override
    // principal && credential 검사하기!
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getPrincipal().toString(); // 아이디
        String password = authentication.getCredentials().toString(); // 비번
        String type;
        UserDetails userDetails;
        if(authentication.getDetails() instanceof MemberDetails) {
            System.out.println("지금 로그인한 얘는 MEMBER 타입이야");
            userDetails = memberDetailsService.loadUserByUsername(email);
            type = "ROLE_MEMBER";
        }
        else if(authentication.getDetails() instanceof AdminDetails) {
            System.out.println("지금 로그인한 얘는 ADMIN 타입이야");
            userDetails = adminDetailsService.loadUserByUsername(email);
            type = "ROLE_ADMIN";
        }
        else throw new PictainException("유효하지 않은 type입니다.", HttpStatus.BAD_REQUEST);
        // 비밀번호 체크
        validateCredential(password, userDetails.getPassword());
        UsernamePasswordAuthenticationToken authenticationRes = new UsernamePasswordAuthenticationToken(email, password, AuthorityUtils.createAuthorityList(type));
        authenticationRes.setDetails(userDetails);
        return authenticationRes;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private void validateCredential(String input_password, String db_password) throws PictainException{
        if(!input_password.equals(db_password)) throw new PictainException("입력하신 비밀번호가 맞지 않습니다.", HttpStatus.BAD_REQUEST);
    }
}
