package photoshoot.backendworkspace.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import photoshoot.backendworkspace.entity.Member;
import photoshoot.backendworkspace.exception.PictainException;
import photoshoot.backendworkspace.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new PictainException("입력하신 이메일이 존재하지 않습니다. 다시 입력해 주세요", HttpStatus.NOT_FOUND));
        return new MemberDetails(member);
    }
}
