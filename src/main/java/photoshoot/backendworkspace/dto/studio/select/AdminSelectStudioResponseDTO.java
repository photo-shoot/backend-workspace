package photoshoot.backendworkspace.dto.studio.select;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.entity.Detail;
import photoshoot.backendworkspace.entity.Price;

@Data
@Builder
public class AdminSelectStudioResponseDTO {
    private String title;
    private String shortDescription;
    private String profileImgName;
    private String profileImgPath;
    private Detail detail;
    private Price price;
    private String address;
    private String spot;
    private Integer minuteFromSpot;
    private Integer likeCnt;
    private Integer scrapCnt;
}
