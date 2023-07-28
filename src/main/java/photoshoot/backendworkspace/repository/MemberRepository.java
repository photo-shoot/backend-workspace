package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
