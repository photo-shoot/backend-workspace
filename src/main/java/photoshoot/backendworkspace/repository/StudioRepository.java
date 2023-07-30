package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long> {
}
