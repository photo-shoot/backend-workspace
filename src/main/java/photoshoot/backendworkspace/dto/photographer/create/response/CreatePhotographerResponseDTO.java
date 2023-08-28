package photoshoot.backendworkspace.dto.photographer.create.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePhotographerResponseDTO {
    private Long storeId;
    private String title;
    private String profileImgName;
    private String profileImgPath;
}
