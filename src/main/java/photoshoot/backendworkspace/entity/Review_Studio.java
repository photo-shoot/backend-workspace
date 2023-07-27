package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review_Studio")
public class Review_Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "reviewer_id")
    private Long reviewerId;

    @Column(name = "studio_id")
    private Long studioId;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "star_rating")
    private Integer starRating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "review_create_dt")
    private Timestamp reviewCreateDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "review_update_dt")
    private Timestamp reviewUpdateDt;
}
