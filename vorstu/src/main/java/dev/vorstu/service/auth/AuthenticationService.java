package dev.vorstu.service.auth;

import dev.vorstu.dto.auth.JwtResponse;
import dev.vorstu.dto.auth.SignInRequest;
import dev.vorstu.entity.UserEntity;
import dev.vorstu.entity.credential.CredentialEntity;
import dev.vorstu.service.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CredentialService credentialService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        CredentialEntity credential = (CredentialEntity) credentialService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        if (credential == null) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        UserEntity userEntity = credential.getUserEntity();
        if (userEntity == null) {
            throw new IllegalArgumentException("User entity not found for the given credentials.");
        }

        Long userId = userEntity.getId();
        var jwt = jwtService.generateToken(credential);

        return new JwtResponse(jwt, userId);
    }

}
