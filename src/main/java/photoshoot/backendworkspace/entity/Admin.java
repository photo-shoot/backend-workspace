package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import photoshoot.backendworkspace.MemberType;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private Long adminId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private MemberType type;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "profile_image_name")
    private String profileImageName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_dt")
    private Timestamp createDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_dt")
    private Timestamp updateDt;

    @Column(name = "studio_id")
    private Long studioId;

    @Column(name = "photographer_id")
    private Long photographerId;

    @Column(name = "studio_chatting_id")
    private Long studioChattingId;

    @Column(name = "photographer_chatting_id")
    private Long photographerChattingId;

    @Column(name = "studio_book_id")
    private Long studioBookId;

    @Column(name = "photographer_book_id")
    private Long photographerBookId;

}