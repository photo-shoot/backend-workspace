package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findAll();
    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);
    Optional<Admin> findByEmail(String email);
}
