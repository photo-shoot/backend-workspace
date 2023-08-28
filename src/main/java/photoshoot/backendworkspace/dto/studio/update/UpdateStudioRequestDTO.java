package photoshoot.backendworkspace.dto.studio.update;

import lombok.Data;
import photoshoot.backendworkspace.entity.Detail;
import photoshoot.backendworkspace.entity.Price;

@Data
public class UpdateStudioRequestDTO {
    private String title;
    private String shortDescription;
    private String profileImgName;
    private String profileImgPath;
    private Detail detail;
    private Price price;
    private String address;
    private String spot;
}
