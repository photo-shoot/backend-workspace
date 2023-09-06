package photoshoot.backendworkspace.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import photoshoot.backendworkspace.entity.Admin;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class AdminDetails implements UserDetails {

    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String type = "ROLE_ADMIN";

    public AdminDetails(Admin admin){
        this.id = admin.getAdminId();
        this.email = admin.getEmail();
        this.password = admin.getPassword();
        this.nickname = admin.getNickname();
    }

    public AdminDetails(String email, String password){
        this.email = email;
        this.password = password;
    }

    public AdminDetails(Long id, String email, String nickname){
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> roles = Arrays.stream(type.split(",")).map(role -> new SimpleGrantedAuthority(email)).collect(Collectors.toList());
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
