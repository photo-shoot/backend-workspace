package photoshoot.backendworkspace.dto.studio;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudioDTO {
    private Long storeId;
    //private AdminDTO admin; 보류
    //private List<Category> categoryList;
    private String title;
    private String shortDescription;
    private String profileImgName;
    private String profileImgPath;
    //private DetailDTO detail; 보류
    //private PriceDTO price; 보류
    //private List<ReviewDTO> reviewList; 리뷰는 할 생각 없음.. 나중에 api 따로 뺄거임. 리뷰탭 누를 때 실행하는 api로
    private Integer likeCnt;
    private Integer scrapCnt;
    //private List<TagDTO> tagList; 보류....ㅜ
    private String address;
    private String spot;
    private Integer minuteFromSpot;

}
