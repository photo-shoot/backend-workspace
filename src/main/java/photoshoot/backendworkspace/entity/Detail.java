package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.dto.detail.CreateDetailDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detail_id")
    private Long detailId;

    @OneToMany(mappedBy = "detail", cascade = CascadeType.ALL, orphanRemoval = true)
    final private List<DetailImage> detailImageList = new ArrayList<>();

    @Column(name = "description")
    private String description;

    static public Detail create(CreateDetailDTO dto){
        Detail createdDetail = Detail.builder()
                .description(dto.getDescription())
                .build();
        dto.getDetailImageDTOList().forEach(detailImageDTO -> {
            DetailImage createdDetailImage = DetailImage.create(detailImageDTO, createdDetail);
            createdDetail.addDetailImage(createdDetailImage);
        });
        return createdDetail;
    }

    public void addDetailImage(DetailImage detailImage){
        this.detailImageList.add(detailImage);
    }
}
