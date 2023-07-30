package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Photographer;

public interface PhotographerRepository extends JpaRepository<Photographer, Long> {
}
