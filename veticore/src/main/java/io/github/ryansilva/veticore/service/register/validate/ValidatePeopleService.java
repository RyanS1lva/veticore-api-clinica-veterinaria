package io.github.ryansilva.veticore.service.register.validate;

import io.github.ryansilva.veticore.repository.PeopleResitory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class ValidatePeopleService {

    private final PeopleResitory peopleResitory;

    public void existsByCpf(String cpf) {
        boolean existsPeople = peopleResitory.existsByCpf(cpf);

        if(existsPeople) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cadastro com este cpf.");
        }
    }

    public void existsByEmail(String email) {
        boolean existsPeople = peopleResitory.existsByEmail(email);

        if(existsPeople) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um cadastro com este e-mail.");
        }
    }
}
