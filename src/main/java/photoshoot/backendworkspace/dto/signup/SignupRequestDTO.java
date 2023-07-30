package photoshoot.backendworkspace.dto.signup;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import photoshoot.backendworkspace.MemberType;
import photoshoot.backendworkspace.entity.Admin;
import photoshoot.backendworkspace.entity.Member;

@Data
public class SignupRequestDTO {

    private String email;
    private String password;
    private String nickname;
    private String type; // MEMBER, ADMIN
    private String profileImageName;

    public static Member toMemberEntity(SignupRequestDTO dto){
        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .profileImageName(dto.getProfileImageName())
                .build();
    }

    public static Admin toAdminEntity(SignupRequestDTO dto){
        return Admin.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .profileImageName(dto.getProfileImageName())
                .build();
    }
}
