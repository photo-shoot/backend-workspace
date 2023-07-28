package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "like_id")
    private Long likeId;
//    @ManyToMany
//    @
//    private Store store;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
