package pet.project.mydebt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pet.project.mydebt.dtos.UserAuthenticationDto;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/api/v1/authorize")
    public ResponseEntity<Authentication> Authentication(@RequestBody UserAuthenticationDto user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
