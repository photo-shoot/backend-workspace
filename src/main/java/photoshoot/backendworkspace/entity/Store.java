package photoshoot.backendworkspace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import photoshoot.backendworkspace.dto.store.CreateStoreRequestDTO;
import photoshoot.backendworkspace.entity.join.LikeStore;
import photoshoot.backendworkspace.entity.join.ScrapStore;
import photoshoot.backendworkspace.entity.join.TagStore;

import java.util.ArrayList;
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToMany
    @JoinTable(name = "Store_Category",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    final private List<Category> categoryList = new ArrayList<>();

    @Column(name = "title")
    private String title;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "profile_img_name")
    private String profileImgName;

    @Column(name = "profile_img_path")
    private String profileImgPath;

    @OneToOne(cascade = CascadeType.ALL)
    private Detail detail;

    @OneToOne(cascade = CascadeType.ALL)
    private Price price;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    final private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    final private List<ScrapStore> scrapStoreList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    final private List<LikeStore> likeStoreList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    final private List<TagStore> tagStoreList = new ArrayList<>();

    @Column(name = "like_cnt")
    private Integer likeCnt;

    @Column(name = "scrap_cnt")
    private Integer scrapCnt;

    public Store(CreateStoreRequestDTO createStoreRequestDTO, Detail detail, Admin admin, Price price){
        this.title = createStoreRequestDTO.getTitle();
        this.shortDescription = createStoreRequestDTO.getShortDescription();
        this.profileImgName = createStoreRequestDTO.getProfileImgName();
        this.profileImgPath = createStoreRequestDTO.getProfileImgPath();
        this.detail = detail;
        this.price = price;
        this.admin = admin;
    }
}
