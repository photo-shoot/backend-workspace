package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Detail_Image")
public class Detail_Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private Long imageId;

    @Column(name = "detail_id")
    private Long detailId;

    @Column(name = "image_name")
    private String imageName;
}
