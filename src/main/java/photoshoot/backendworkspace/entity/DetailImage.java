package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.dto.image.DetailImageDTO;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Image")
public class DetailImage { // detail이미지
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iamge_id")
    private Long imageId;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id")
    private Detail detail;

    public static DetailImage create(DetailImageDTO dto, Detail detail){
        return DetailImage.builder()
                .imageName(dto.getImageName())
                .imagePath(dto.getImagePath())
                .detail(detail)
                .build();
    }
}
