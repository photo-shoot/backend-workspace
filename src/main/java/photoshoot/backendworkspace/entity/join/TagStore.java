package photoshoot.backendworkspace.entity.join;

import jakarta.persistence.*;
import lombok.Data;
import photoshoot.backendworkspace.entity.Scrap;
import photoshoot.backendworkspace.entity.Store;

@Data
@Entity
@Table(name = "Tag_Store")
// Tag와 Store은 N:N 관계다.
public class TagStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scrap_store_id")
    private Long scrap_store_id;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Scrap tag;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
