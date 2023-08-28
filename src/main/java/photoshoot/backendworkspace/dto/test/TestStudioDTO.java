package photoshoot.backendworkspace.dto.test;

import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.entity.Photographer;
import photoshoot.backendworkspace.entity.Studio;

@Data
@Builder
public class TestStudioDTO {
    private Long storeId;
    private Long adminId;
    private String title;
    private String shortDescription;
    private String address;
    private String spot;
    private Integer minuteFromSpot;
    private String profileImgName;
    private String profileImgPath;
    private Integer likeCnt;
    private Integer scrapCnt;
    public static TestStudioDTO toDTO(Studio entity){
        return TestStudioDTO.builder()
                .storeId(entity.getStoreId())
                .adminId(entity.getAdmin().getAdminId())
                .title(entity.getTitle())
                .shortDescription(entity.getShortDescription())
                .address(entity.getAddress())
                .spot(entity.getSpot())
                .minuteFromSpot(entity.getMinuteFromSpot())
                .profileImgName(entity.getProfileImgName())
                .profileImgPath(entity.getProfileImgPath())
                .likeCnt(entity.getLikeCnt())
                .scrapCnt(entity.getScrapCnt())
                .build();
    }
}
