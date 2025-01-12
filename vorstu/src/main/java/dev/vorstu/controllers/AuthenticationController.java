package dev.vorstu.controllers;

import dev.vorstu.dto.auth.JwtResponse;
import dev.vorstu.dto.auth.SignInRequest;
import dev.vorstu.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping
    public JwtResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
