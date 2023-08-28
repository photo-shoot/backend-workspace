package photoshoot.backendworkspace.dto.detail;

import lombok.Builder;
import lombok.Data;
import photoshoot.backendworkspace.dto.image.DetailImageDTO;

import java.util.List;

@Data
@Builder
public class CreateDetailDTO {
    String description;
    List<DetailImageDTO> detailImageDTOList;
}
