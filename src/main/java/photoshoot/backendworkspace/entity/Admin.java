package photoshoot.backendworkspace.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.MemberType;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private Long adminId;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private Timestamp createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private Timestamp updateDt;

    @OneToMany(mappedBy = "admin")
    final private List<Store> storeList = new ArrayList<>();

}