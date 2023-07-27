package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.MemberType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Detail_Studio")
public class Detail_Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detail_id")
    private Long detailId;

    @Column(name = "detail_text")
    private String detailText;
}
