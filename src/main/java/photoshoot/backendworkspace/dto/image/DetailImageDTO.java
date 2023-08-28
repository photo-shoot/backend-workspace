package photoshoot.backendworkspace.dto.image;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailImageDTO {
    private String imageName;
    private String imagePath;
}
