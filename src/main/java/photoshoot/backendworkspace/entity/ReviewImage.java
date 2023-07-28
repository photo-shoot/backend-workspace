package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Review_Image")
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_image_id")
    private Long reviewImageId;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

}
