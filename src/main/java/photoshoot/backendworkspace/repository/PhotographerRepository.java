package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Photographer;

import java.util.Optional;

public interface PhotographerRepository extends JpaRepository<Photographer, Long> {
    Optional<Photographer> findByStoreId(Long storeId);
}
