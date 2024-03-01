package pet.project.mydebt.services;

import pet.project.mydebt.entities.User;

public interface UserService {
    void save(User user);

    User update(User user);

    void delete(User user);

    User findById(Long id);

    boolean existsByUsername(String username);

    User findByUsername(String username);
}
