package pet.project.mydebt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.project.mydebt.dtos.UserRegistrationDto;
import pet.project.mydebt.entities.Role;
import pet.project.mydebt.entities.User;
import pet.project.mydebt.exceptions.BusinessException;
import pet.project.mydebt.services.RoleService;
import pet.project.mydebt.services.UserService;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegistrationController {
    private final RoleService roleService;
    private final UserService userService;
    @PostMapping("/registration")
    public ResponseEntity<String> addUser(@RequestBody UserRegistrationDto user) {
        try {
            Role roleUser = roleService.findByRole("USER");
            userService.save(new User(null, user.getLastName(), user.getMiddleName(), user.getFirstName(),
                    user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail(),
                    Collections.singletonList(roleUser), null));
        } catch(BusinessException exception) {
            return new ResponseEntity<>("\"" + exception.getMessage() + "\"", HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/existOfUsername/{username}")
    public ResponseEntity<Boolean> checkExistOfUsername(@PathVariable String username) {
    return new ResponseEntity<>(userService.existsByUsername(username), HttpStatus.OK);
    }
}
