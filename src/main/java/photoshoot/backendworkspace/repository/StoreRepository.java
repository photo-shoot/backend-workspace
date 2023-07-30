package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    }
