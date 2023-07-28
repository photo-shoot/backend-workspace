package photoshoot.backendworkspace.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    @Column(name = "etc")
    private String etc;
}
