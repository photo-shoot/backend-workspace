package photoshoot.backendworkspace.dto.store;

import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.dto.detail.CreateDetailDTO;
import photoshoot.backendworkspace.dto.price.CreatePriceDTO;
import photoshoot.backendworkspace.dto.tag.TagDTO;

import java.util.List;

@Data
@Builder
public class CreateStoreRequestDTO {
    // adminId로 admin 회원 찾기
    private Long adminId;
    // 카테고리 추가해야함
    //private category...
    private String title;
    private String shortDescription;
    private String profileImgName;
    private String profileImgPath;
    private CreateDetailDTO createDetailDTO;
    //private List<TagDTO> tagDTOList; 보류,....ㅜ,ㅡㅠㅠㅠ
    private List<CreatePriceDTO> createPriceDTOList;
}
