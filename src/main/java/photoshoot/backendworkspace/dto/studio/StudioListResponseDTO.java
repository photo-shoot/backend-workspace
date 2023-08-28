package photoshoot.backendworkspace.dto.studio;

import jakarta.persistence.Column;
import lombok.Data;
import photoshoot.backendworkspace.dto.photographer.PhotographerDTO;

import java.util.List;

@Data
public class StudioListResponseDTO {
    private Long storeId;
    private List<StudioDTO> photographerDTOList;
    private Integer pageNo;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private Boolean last;
}
