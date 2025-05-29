package io.github.ryansilva.veticore.controller.request.people;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class RegisterPeopleRequest {

    @NotBlank(message = "Nome é obrigatório.")
    private String name;

    @CPF(message = "Insira um cpf válido.")
    @NotBlank(message = "CPF é obrigatório.")
    private String cpf;

    @NotBlank(message = "Telefone é obrigatório.")
    private String phone;

    @Email(message = "Insira um e-mail válido.")
    private String email;
}
