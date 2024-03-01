package pet.project.mydebt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.project.mydebt.dtos.UserRegistrationDto;
import pet.project.mydebt.entities.User;
import pet.project.mydebt.services.UserService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<Void> addUser(@RequestBody UserRegistrationDto user) {
        userService.save(new User(null, user.getLastName(), user.getMiddleName(), user.getFirstName(),
                user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail(), null, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
