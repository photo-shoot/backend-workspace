package photoshoot.backendworkspace.dto.test;

import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.dto.photographer.PhotographerDTO;
import photoshoot.backendworkspace.entity.Detail;
import photoshoot.backendworkspace.entity.Photographer;

@Data
@Builder
public class TestPhotographerDTO {
    private Long storeId;
    private Long adminId;
    private String title;
    private String shortDescription;
    private String place;
    private Boolean isBusinessTrip;
    private String profileImgName;
    private String profileImgPath;
    private Integer likeCnt;
    private Integer scrapCnt;
    public static TestPhotographerDTO toDTO(Photographer entity){
        return TestPhotographerDTO.builder()
                .storeId(entity.getStoreId())
                .adminId(entity.getAdmin().getAdminId())
                .title(entity.getTitle())
                .shortDescription(entity.getShortDescription())
                .place(entity.getPlace())
                .isBusinessTrip(entity.getIsBusinessTrip())
                .profileImgName(entity.getProfileImgName())
                .profileImgPath(entity.getProfileImgPath())
                .likeCnt(entity.getLikeCnt())
                .scrapCnt(entity.getScrapCnt())
                .build();
    }
}
