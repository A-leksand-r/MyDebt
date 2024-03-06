package pet.project.mydebt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pet.project.mydebt.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
