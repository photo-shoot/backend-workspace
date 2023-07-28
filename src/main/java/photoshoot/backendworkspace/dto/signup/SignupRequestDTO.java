package photoshoot.backendworkspace.dto.signup;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import photoshoot.backendworkspace.MemberType;

@Data
public class SignupRequestDTO {
    private String email;
    private String password;
    private String nickname;
    private MemberType type;
    private String profileImageName;
}
