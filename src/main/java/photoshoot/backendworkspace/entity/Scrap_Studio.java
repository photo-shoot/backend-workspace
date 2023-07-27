package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Scrap_Studio")
public class Scrap_Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scrap_id")
    private Long scrapId;
    @Column(name = "studio_id")
    private Long studioId;
    @Column(name = "member_id")
    private Long memberId;
}
