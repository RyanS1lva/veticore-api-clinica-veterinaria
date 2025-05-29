package io.github.ryansilva.veticore.repository;

import io.github.ryansilva.veticore.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@NotBlank(message = "Preencha o email.") @Email(message = "Digite um formato de e-mail válido.") String email);
}
