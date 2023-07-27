package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Price_Photographer")
public class Price_Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long priceId;

    @Column(name = "price_keys")
    private String priceKeys;

    @Column(name = "price_values")
    private Integer priceValues;

    @Column(name = "etc")
    private String etc;
}
