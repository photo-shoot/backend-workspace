package photoshoot.backendworkspace.dto.sign;

import lombok.Data;

@Data
public class SigninRequestDTO {
    private String email;
    private String password;
    private String type;
}
