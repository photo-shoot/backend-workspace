package photoshoot.backendworkspace.dto.refreshToken;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.entity.RefreshToken;

import java.sql.Timestamp;

@Data
@Builder
public class RefreshTokenResponseDTO {
    Long id;
    Timestamp createdDt;
    Long expirationTime;
    public static RefreshTokenResponseDTO toDTO(RefreshToken entity){
        return RefreshTokenResponseDTO.builder()
                .id(entity.getId())
                .createdDt(entity.getCreatedDt())
                .expirationTime(entity.getExpirationTime())
                .build();
    }
}
