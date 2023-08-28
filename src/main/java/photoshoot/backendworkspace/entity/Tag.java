package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.dto.tag.TagDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "tag_value")
    private String tagValue;

    public static TagDTO toDTO(Tag entity){
        return TagDTO.builder()
                .tagValue(entity.getTagValue())
                .build();
    }
}

