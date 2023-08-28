package photoshoot.backendworkspace.entity.join;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import photoshoot.backendworkspace.entity.Scrap;
import photoshoot.backendworkspace.entity.Store;
import photoshoot.backendworkspace.entity.Tag;

@Data
@Entity
@Table(name = "Tag_Store")
// Tag와 Store은 N:N 관계다.
public class TagStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_store_id")
    private Long tag_store_id;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
