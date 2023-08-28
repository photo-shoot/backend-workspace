package photoshoot.backendworkspace.dto.photographer.update;

import lombok.Data;
import photoshoot.backendworkspace.entity.Detail;
import photoshoot.backendworkspace.entity.Price;

@Data
public class UpdatePhotographerRequestDTO {
    private String title;
    private String shortDescription;
    private String profileImgName;
    private String profileImgPath;
    private Detail detail;
    private Price price;
    private String place;
    private Boolean isBusinessTrip;
}
