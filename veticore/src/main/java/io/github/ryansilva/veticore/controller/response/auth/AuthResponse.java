package io.github.ryansilva.veticore.controller.response.auth;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String token;
    private Long expirationDays;
}
