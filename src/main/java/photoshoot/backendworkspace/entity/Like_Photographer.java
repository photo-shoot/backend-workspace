package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Like_Photographer")
public class Like_Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "like_id")
    private Long likeId;
    @Column(name = "photographer_id")
    private Long photographerId;
    @Column(name = "member_id")
    private Long memberId;
}
