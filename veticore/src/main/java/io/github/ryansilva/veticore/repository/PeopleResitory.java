package io.github.ryansilva.veticore.repository;

import io.github.ryansilva.veticore.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleResitory extends JpaRepository<People, Long> {
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}
