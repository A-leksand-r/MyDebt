package pet.project.mydebt.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pet.project.mydebt.entities.User;
import pet.project.mydebt.exceptions.BusinessException;
import pet.project.mydebt.exceptions.enums.UserServiceFailedCode;
import pet.project.mydebt.repositories.UserRepository;
import pet.project.mydebt.services.UserService;
import pet.project.mydebt.utils.UserUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public void save(User user) throws BusinessException {
        if (existsByUsername(user.getUsername())) {
            throw new BusinessException("Пользователь c таким именем уже существует", UserServiceFailedCode.ALREADY_EXISTS);
        }
        else {
            List<String> errors = UserUtils.validateFields(user);
            if (!errors.isEmpty()) {
                throw new BusinessException("Ошибка валидации", UserServiceFailedCode.VALIDATE_FAILED, String.join("\n", errors));
            }
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь в базе данных не найден");
        }
        return user.get();
    }
}
