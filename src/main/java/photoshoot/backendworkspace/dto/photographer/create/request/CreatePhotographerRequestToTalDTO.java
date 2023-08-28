package photoshoot.backendworkspace.dto.photographer.create.request;

import lombok.Data;
import photoshoot.backendworkspace.dto.store.CreateStoreRequestDTO;
import photoshoot.backendworkspace.dto.studio.create.request.CreateStudioRequestDTO;

@Data
public class CreatePhotographerRequestToTalDTO {
    CreateStoreRequestDTO createStoreRequestDTO;
    CreatePhotographerRequestDTO createPhotographerRequestDTO;
}
