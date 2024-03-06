package pet.project.mydebt.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pet.project.mydebt.entities.Role;
import pet.project.mydebt.repositories.RoleRepository;
import pet.project.mydebt.services.RoleService;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
