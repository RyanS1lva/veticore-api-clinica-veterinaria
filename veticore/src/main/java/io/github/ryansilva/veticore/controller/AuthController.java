package io.github.ryansilva.veticore.controller;

import io.github.ryansilva.veticore.controller.request.AuthRequest;
import io.github.ryansilva.veticore.controller.response.AuthResponse;
import io.github.ryansilva.veticore.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public AuthResponse auth(@Valid @RequestBody AuthRequest request) {
        return authService.auth(request);
    }
}
