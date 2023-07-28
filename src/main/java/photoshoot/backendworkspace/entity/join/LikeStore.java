package photoshoot.backendworkspace.entity.join;

import jakarta.persistence.*;
import lombok.Data;
import photoshoot.backendworkspace.entity.Like;
import photoshoot.backendworkspace.entity.Store;

@Data
@Entity
@Table(name = "Like_Store")
// Like와 Store는 N:N 관계임
public class LikeStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "like_store_id")
    private Long like_store_id;
    @ManyToOne
    @JoinColumn(name = "like_id")
    private Like like;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
