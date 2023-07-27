package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Photographer")
public class Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photographer_id")
    private Long photographerId;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "name")
    private String name;

    @Column(name = "short_intro")
    private String shortIntro;

    @Column(name = "profile_img_name")
    private String profileImgName;

    @Column(name = "place")
    private String place;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "is_business_trip")
    private Boolean isBusinessTrip;

    @Column(name = "photographer_detail_id")
    private Integer photographerDetailId;

    @Column(name = "photographer_price_id")
    private Integer photographerPriceId;

    @Column(name = "photographer_chatting_id")
    private Integer photographerChattingId;

    @Column(name = "like")
    private Integer like;

    @Column(name = "scrap")
    private Integer scrap;

}
