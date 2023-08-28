package photoshoot.backendworkspace.dto.photographer.select;

import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.entity.Detail;
import photoshoot.backendworkspace.entity.Price;

@Data
@Builder
public class AdminSelectPhotographerResponseDTO {
    private String title;
    private String shortDescription;
    private String profileImgName;
    private String profileImgPath;
    private Detail detail;
    private Price price;
    private String place;
    private Boolean isBusinessTrip;
    private Integer likeCnt;
    private Integer scrapCnt;
}
