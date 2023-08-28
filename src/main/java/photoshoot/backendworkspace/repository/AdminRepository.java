package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findAll();
    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);

}
