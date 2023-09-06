package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAll();
    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);
    Optional<Member> findByEmail(String email);
}
