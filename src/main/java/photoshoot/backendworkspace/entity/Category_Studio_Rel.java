package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Category_Studio_Rel")
public class Category_Studio_Rel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_studio_rel_id")
    private Long categoryStudioRelId;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "studio_id")
    private Long studioId;
}
