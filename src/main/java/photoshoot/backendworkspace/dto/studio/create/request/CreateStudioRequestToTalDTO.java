package photoshoot.backendworkspace.dto.studio.create.request;

import lombok.Data;
import photoshoot.backendworkspace.dto.store.CreateStoreRequestDTO;

@Data
public class CreateStudioRequestToTalDTO {
    CreateStoreRequestDTO createStoreRequestDTO;
    CreateStudioRequestDTO createStudioRequestDTO;
}
