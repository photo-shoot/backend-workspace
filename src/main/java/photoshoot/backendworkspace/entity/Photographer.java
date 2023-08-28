package photoshoot.backendworkspace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.dto.photographer.PhotographerDTO;
import photoshoot.backendworkspace.dto.photographer.create.request.CreatePhotographerRequestDTO;
import photoshoot.backendworkspace.dto.photographer.create.response.CreatePhotographerResponseDTO;
import photoshoot.backendworkspace.dto.photographer.select.AdminSelectPhotographerResponseDTO;
import photoshoot.backendworkspace.dto.store.CreateStoreRequestDTO;


@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Photographer")
public class Photographer extends Store{
    @Column(name = "place")
    private String place; // 촬영장소
    @Column(name = "isBusiness_trip")
    private Boolean isBusinessTrip; // 출장 가능 여부

    public Photographer(CreateStoreRequestDTO storeDTO, CreatePhotographerRequestDTO photographerDTO, Detail detail, Price price, Admin admin){
        super(storeDTO, detail, admin, price);
        this.place = photographerDTO.getPlace();
        this.isBusinessTrip = photographerDTO.getIsBusinessTrip();
    }

    public static Photographer create(CreateStoreRequestDTO storeDTO, CreatePhotographerRequestDTO photographerDTO, Detail detail, Price price, Admin admin){
        return new Photographer(storeDTO, photographerDTO, detail, price, admin);
    }

    public static PhotographerDTO toDTO(Photographer entity){
        return PhotographerDTO.builder()
                .storeId(entity.getStoreId())
                .title(entity.getTitle())
                .shortDescription(entity.getShortDescription())
                .profileImgName(entity.getProfileImgName())
                .profileImgPath(entity.getProfileImgPath())
                .likeCnt(entity.getLikeCnt())
                .scrapCnt(entity.getScrapCnt())
                //.tagList(entity.get())
                .place(entity.getPlace())
                .isBusinessTrip(entity.getIsBusinessTrip())
                .build();
    }

    public static CreatePhotographerResponseDTO toCreateResponseDTO(Photographer entity){
        return CreatePhotographerResponseDTO.builder()
                .storeId(entity.getStoreId())
                .title(entity.getTitle())
                .profileImgName(entity.getProfileImgName())
                .profileImgPath(entity.getProfileImgPath())
                .build();
    }

    public static AdminSelectPhotographerResponseDTO toAdminSelectResponseDTO(Photographer entity){
        return AdminSelectPhotographerResponseDTO.builder()
                .title(entity.getTitle())
                .shortDescription(entity.getShortDescription())
                .profileImgName(entity.getProfileImgName())
                .profileImgPath(entity.getProfileImgPath())
                .detail(entity.getDetail())
                .price(entity.getPrice())
                .place(entity.getPlace())
                .isBusinessTrip(entity.getIsBusinessTrip())
                .likeCnt(entity.getLikeCnt())
                .scrapCnt(entity.getScrapCnt())
                .build();
    }
}
