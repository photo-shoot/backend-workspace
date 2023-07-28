package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.entity.join.LikeStore;
import photoshoot.backendworkspace.entity.join.ScrapStore;
import photoshoot.backendworkspace.entity.join.TagStore;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "store_type")
@Table(name="Store")
public abstract class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private Long storeId;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToMany
    @JoinTable(name = "Store_Category",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoryList;

    @Column(name = "title")
    private String title;

    @Column(name = "short_description")
    private String shortdescription;

    @Column(name = "profile_img_name")
    private String profileImgName;

    @OneToOne
    private Detail detail;

    @OneToOne
    private Price price;

    @OneToMany(mappedBy = "store")
    private List<Review> reviewList;

    @OneToMany(mappedBy = "store")
    private List<ScrapStore> scrapStoreList;

    @OneToMany(mappedBy = "store")
    private List<LikeStore> likeStoreList;

    @OneToMany(mappedBy = "store")
    private List<TagStore> tagStoreList;

    @Column(name = "like_cnt")
    private Integer likeCnt;

    @Column(name = "scrap_cnt")
    private Integer scrapCnt;
}
