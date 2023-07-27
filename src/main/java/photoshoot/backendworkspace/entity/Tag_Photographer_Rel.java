package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Tag_Photographer_Rel")
public class Tag_Photographer_Rel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_studio_rel_id")
    private Long tagStudioRelId;
    @Column(name = "tag_id")
    private Long tagId;
    @Column(name = "photographer_id")
    private Long photographerId;
}
