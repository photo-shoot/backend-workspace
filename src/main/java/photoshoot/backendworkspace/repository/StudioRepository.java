package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Studio;

import java.util.Optional;

public interface StudioRepository extends JpaRepository<Studio, Long> {
    Optional<Studio> findByStoreId(Long storeId);
}
