package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import photoshoot.backendworkspace.MemberType;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "profile_image_name")
    private String profileImageName;

    @Column(name = "profile_image_path")
    private String profileImagePath;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private Timestamp createDt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private Timestamp updateDt;

    @OneToMany(mappedBy = "member")
    final private List<Scrap> scrapList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    final private List<Like> likeList = new ArrayList<>();

}
