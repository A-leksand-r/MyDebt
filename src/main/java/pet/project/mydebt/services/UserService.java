package pet.project.mydebt.services;

import pet.project.mydebt.entities.User;
import pet.project.mydebt.exceptions.BusinessException;

public interface UserService {
    void save(User user) throws BusinessException;

    User update(User user);

    void delete(User user);

    User findById(Long id);

    boolean existsByUsername(String username);

    User findByUsername(String username);
}
