package photoshoot.backendworkspace.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.dto.price.CreatePriceDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="Price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "price_id")
    private Long priceId;

    @Column(name = "price_names")
    private String priceName;

    @Column(name = "price_values")
    private String priceValue;

    @Column(name = "etcs")
    private String etc;

    public static Price create(List<CreatePriceDTO> createPriceDTOList){
        final String priceNameStr = "";
        final String priceValueStr = "";
        final String priceEtcStr = "";
        createPriceDTOList.forEach(createPriceDTO -> {
            priceNameStr.concat(createPriceDTO.getPriceName() + ",");
            priceValueStr.concat(createPriceDTO.getPriceValue() + ",");
            priceEtcStr.concat(createPriceDTO.getEtc() + ",");
        });
        Price createdPrice = Price.builder()
                .priceName(priceNameStr)
                .priceValue(priceValueStr)
                .etc(priceEtcStr)
                .build();
        return createdPrice;
    }
}
