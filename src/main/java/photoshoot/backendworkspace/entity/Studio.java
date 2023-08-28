package photoshoot.backendworkspace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import photoshoot.backendworkspace.dto.store.CreateStoreRequestDTO;
import photoshoot.backendworkspace.dto.studio.StudioDTO;
import photoshoot.backendworkspace.dto.studio.create.request.CreateStudioRequestDTO;
import photoshoot.backendworkspace.dto.studio.create.response.CreateStudioResponseDTO;
import photoshoot.backendworkspace.dto.studio.select.AdminSelectStudioResponseDTO;

@Data
@Entity
@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Studio")
public class Studio extends Store{
    @Column(name = "address")
    private String address;
    @Column(name = "spot")
    private String spot;
    @Column(name = "minute_from_spot")
    private Integer minuteFromSpot;

    public Studio(CreateStoreRequestDTO storeDTO, CreateStudioRequestDTO studioDTO, Detail detail, Price price, Admin admin){
        super(storeDTO, detail, admin, price);
        this.address = studioDTO.getAddress();
        this.spot = studioDTO.getSpot();
        this.minuteFromSpot = studioDTO.getMinuteFromSpot();
    }

    public static Studio create(CreateStoreRequestDTO storeDTO, CreateStudioRequestDTO studioDTO, Detail detail, Price price, Admin admin){
        return new Studio(storeDTO, studioDTO, detail, price, admin);
    }

    public static StudioDTO toDTO(Studio entity){
        return StudioDTO.builder()
                .storeId(entity.getStoreId())
                .title(entity.getTitle())
                .shortDescription(entity.getShortDescription())
                .profileImgName(entity.getProfileImgName())
                .profileImgPath(entity.getProfileImgPath())
                .likeCnt(entity.getLikeCnt())
                .scrapCnt(entity.getScrapCnt())
                .address(entity.getAddress())
                .spot(entity.getAddress())
                .minuteFromSpot(entity.getMinuteFromSpot())
                .build();
    }

    public static CreateStudioResponseDTO toCreateResponseDTO(Studio entity){
        return CreateStudioResponseDTO.builder()
                .storeId(entity.getStoreId())
                .title(entity.getTitle())
                .profileImgName(entity.getProfileImgName())
                .profileImgPath(entity.getProfileImgPath())
                .build();
    }

    public static AdminSelectStudioResponseDTO toAdminSelectResponseDTO(Studio entity){
        return AdminSelectStudioResponseDTO.builder()
                .title(entity.getTitle())
                .shortDescription(entity.getShortDescription())
                .profileImgName(entity.getProfileImgName())
                .profileImgPath(entity.getProfileImgPath())
                .detail(entity.getDetail())
                .price(entity.getPrice())
                .address(entity.getAddress())
                .spot(entity.getSpot())
                .minuteFromSpot(entity.getMinuteFromSpot())
                .likeCnt(entity.getLikeCnt())
                .scrapCnt(entity.getScrapCnt())
                .build();
    }

}
