package pet.project.mydebt.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.project.mydebt.dtos.UserAuthenticationDto;
import pet.project.mydebt.services.AuthenticationService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authorize")
    public ResponseEntity<Void> authentication(@RequestBody UserAuthenticationDto user, HttpServletRequest request, HttpServletResponse response) {
        authenticationService.authenticate(user, request, response);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
