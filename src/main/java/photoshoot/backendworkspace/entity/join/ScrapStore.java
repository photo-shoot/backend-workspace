package photoshoot.backendworkspace.entity.join;

import jakarta.persistence.*;
import lombok.Data;
import photoshoot.backendworkspace.entity.Scrap;
import photoshoot.backendworkspace.entity.Store;

@Data
@Entity
@Table(name = "Scrap_Store")
// Scrap과 Store가 N:N 관계임
public class ScrapStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scrap_store_id")
    private Long scrap_store_id;
    @ManyToOne
    @JoinColumn(name = "scrap_id")
    private Scrap scrap;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
