package photoshoot.backendworkspace.dto.test;

import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.entity.Member;

@Data
@Builder
public class TestMemberDTO {
    private Long adminId;
    private String email;
    private String password;
    private String nickname;
    private String profileImageName;
    private String profileImagePath;

    public static TestMemberDTO toDTO(Member entity){
        return TestMemberDTO.builder()
                .adminId(entity.getMemberId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nickname(entity.getNickname())
                .profileImageName(entity.getProfileImageName())
                .profileImagePath(entity.getProfileImagePath())
                .build();
    }
}
