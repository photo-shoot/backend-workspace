package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Scrap_Photographer")
public class Scrap_Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scrap_id")
    private Long scrapId;
    @Column(name = "photographer_id")
    private Long photographerId;
    @Column(name = "member_id")
    private Long memberId;
}
