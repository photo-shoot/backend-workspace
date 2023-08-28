package photoshoot.backendworkspace.dto.sign;

import lombok.Data;
import photoshoot.backendworkspace.entity.Admin;
import photoshoot.backendworkspace.entity.Member;

@Data
public class SignupRequestDTO {

    private String email;
    private String password;
    private String nickname;
    private String type; // MEMBER, ADMIN
    private String profileImageName;
    private String profileImagePath;

    public static Member toMemberEntity(SignupRequestDTO dto){
        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .profileImageName(dto.getProfileImageName())
                .profileImagePath(dto.getProfileImagePath())
                .build();
    }

    public static Admin toAdminEntity(SignupRequestDTO dto){
        return Admin.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .profileImageName(dto.getProfileImageName())
                .profileImagePath(dto.getProfileImagePath())
                .build();
    }
}
