package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "refresh_token")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "refreshToken_id")
    Long id; // 리프레시 토큰 아이디
    @Column(name = "token")
    String token;
    @Column(name = "userId")
    Long userId; // 발급 받은 유저 아이디
    @Column(name = "email")
    String email;
    @Column(name = "type")
    String type;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_dt")
    Timestamp createdDt;
    @Column(name = "expiration_time")
    Long expirationTime;

    public static RefreshToken toEntity(String token, Long userId, String email, String type){
        return RefreshToken.builder()
                .token(token)
                .userId(userId)
                .email(email)
                .type(type)
                .build();
    }
}
