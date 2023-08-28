package photoshoot.backendworkspace.dto.price;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePriceDTO {
    private String priceName;
    private Integer priceValue;
    private String etc;
}
