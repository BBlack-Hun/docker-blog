package kr.co.bblackhun.dockerblog.user.repository;

import kr.co.bblackhun.dockerblog.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
