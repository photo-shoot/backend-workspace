package photoshoot.backendworkspace.dto.test;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.entity.Admin;
import photoshoot.backendworkspace.entity.Store;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TestAdminDTO {
    private Long adminId;
    private String email;
    private String password;
    private String nickname;
    private String profileImageName;
    private String profileImagePath;

    public static TestAdminDTO toDTO(Admin entity){
        return TestAdminDTO.builder()
                .adminId(entity.getAdminId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .nickname(entity.getNickname())
                .profileImageName(entity.getProfileImageName())
                .profileImagePath(entity.getProfileImagePath())
                .build();
    }
}
