package photoshoot.backendworkspace.dto.photographer.create.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreatePhotographerRequestDTO {
    private String place; // 촬영장소
    private Boolean isBusinessTrip; // 출장 가능 여부
}
