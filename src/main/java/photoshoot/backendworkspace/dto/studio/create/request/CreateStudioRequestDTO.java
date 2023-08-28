package photoshoot.backendworkspace.dto.studio.create.request;

import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.dto.store.CreateStoreRequestDTO;

@Data
@Builder
public class CreateStudioRequestDTO {
    private String address;
    private String spot;
    private Integer minuteFromSpot;
}
