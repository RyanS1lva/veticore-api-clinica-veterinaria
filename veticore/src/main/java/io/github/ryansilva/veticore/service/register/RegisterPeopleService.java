package io.github.ryansilva.veticore.service.register;

import io.github.ryansilva.veticore.controller.request.people.RegisterPeopleRequest;
import io.github.ryansilva.veticore.controller.response.people.PeopleResponse;
import io.github.ryansilva.veticore.mapper.people.RegisterPeopleMapper;
import io.github.ryansilva.veticore.model.People;
import io.github.ryansilva.veticore.repository.PeopleResitory;
import io.github.ryansilva.veticore.service.register.validate.ValidatePeopleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegisterPeopleService {

    private final PeopleResitory peopleResitory;

    private final ValidatePeopleService validatePeopleService;

    public PeopleResponse register(@Valid RegisterPeopleRequest request) {
        validatePeopleService.existsByCpf(request.getCpf());
        validatePeopleService.existsByEmail(request.getEmail());

        People people = RegisterPeopleMapper.toEntity(request);

        peopleResitory.save(people);

        return RegisterPeopleMapper.toResponse(people);
    }
}
