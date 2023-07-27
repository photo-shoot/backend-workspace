package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Category_Photographer_Rel")
public class Category_Photographer_Rel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_photographer_rel_id")
    private Long categoryPhotographerRelId;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "photographer_id")
    private Long photographerId;
}
