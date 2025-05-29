package io.github.ryansilva.veticore.controller.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthRequest {

    @NotBlank(message = "Preencha o email.")
    @Email(message = "Digite um formato de e-mail válido.")
    private String email;

    @NotBlank(message = "Preencha a senha.")
    private String password;
}
