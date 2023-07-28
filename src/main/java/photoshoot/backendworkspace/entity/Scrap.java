package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Scrap")
public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scrap_id")
    private Long scrapId;
//    @ManyToOne
//    @JoinColumn(name = "store_id")
//    private Store store;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
