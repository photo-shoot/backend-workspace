package photoshoot.backendworkspace.dto.photographer;

import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.dto.tag.TagDTO;
import photoshoot.backendworkspace.entity.Admin;
import photoshoot.backendworkspace.entity.Category;

import java.util.List;

@Data
@Builder
public class PhotographerDTO {
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
    private String place;
    private Boolean isBusinessTrip;

}
