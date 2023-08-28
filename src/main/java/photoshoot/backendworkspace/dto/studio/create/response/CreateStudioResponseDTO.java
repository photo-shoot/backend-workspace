package photoshoot.backendworkspace.dto.studio.create.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStudioResponseDTO {
    private Long storeId;
    private String title;
    private String profileImgName;
    private String profileImgPath;
}
