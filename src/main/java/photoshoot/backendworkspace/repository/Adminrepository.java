package photoshoot.backendworkspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photoshoot.backendworkspace.entity.Admin;

public interface Adminrepository extends JpaRepository<Admin, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByNickname(String nickname);

}
