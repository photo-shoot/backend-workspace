package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAll();
    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);
}
