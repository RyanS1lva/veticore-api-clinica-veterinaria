package io.github.ryansilva.veticore.service;

import io.github.ryansilva.veticore.controller.request.AuthRequest;
import io.github.ryansilva.veticore.controller.response.AuthResponse;
import io.github.ryansilva.veticore.model.User;
import io.github.ryansilva.veticore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtEncoder jwtEncoder;

    public AuthResponse auth(AuthRequest request) {

        Optional<User> optUser = userRepository.findByEmail(request.getEmail());

        if(optUser.isEmpty() || !isLoginCorrect(request.getPassword(), optUser.get().getPassword())) {
            throw new BadCredentialsException("E-mail ou senha incorretos.");
        }

        User user = optUser.get();
        long expiresIn = 1L;

        JwtClaimsSet jwt = JwtClaimsSet.builder()
                .issuer("veticore")
                .subject(user.getName())
                .expiresAt(Instant.now().plus(Duration.ofDays(expiresIn)))
                .issuedAt(Instant.now())
                .claim("email", user.getEmail())
                .build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();

        return new AuthResponse(token, expiresIn);
    }

    private boolean isLoginCorrect(String password, String savedPassword) {
        return passwordEncoder.matches(password, savedPassword);
    }
}
