package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member reviewer;

    @Column(name = "review_title")
    private String reviewTitle;

    @Column(name = "review_text")
    private String reviewText;

    @OneToMany(mappedBy = "review")
    private List<ReviewImage> reviewImageList;

    @Column(name = "star_rating")
    private String starRating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "review_create_dt")
    private Timestamp reviewCreateDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "review_update_dt")
    private Timestamp reviewUpdateDt;
}
