package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.MemberType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Studio")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studio_id")
    private Long studioId;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "name")
    private String name;

    @Column(name = "short_intro")
    private String shortIntro;

    @Column(name = "address")
    private String address;

    @Column(name = "profile_img_name")
    private String profileImgName;

    @Column(name = "distance")
    private String distance;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "studio_detail_id")
    private Integer studioDetailId;

    @Column(name = "studio_price_id")
    private Integer studioPriceId;

    @Column(name = "studio_chatting_id")
    private Integer studioChattingId;

    @Column(name = "like")
    private Integer like;

    @Column(name = "scrap")
    private Integer scrap;

}
