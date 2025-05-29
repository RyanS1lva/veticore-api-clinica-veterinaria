package io.github.ryansilva.veticore.mapper.people;

import io.github.ryansilva.veticore.controller.request.people.RegisterPeopleRequest;
import io.github.ryansilva.veticore.controller.response.people.PeopleResponse;
import io.github.ryansilva.veticore.model.People;
import jakarta.validation.Valid;

public class RegisterPeopleMapper {

    public static People toEntity(@Valid RegisterPeopleRequest request) {
        return People.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .build();
    }

    public static PeopleResponse toResponse(People people) {
        return PeopleResponse.builder()
                .id(people.getId())
                .name(people.getName())
                .createdAt(people.getCreatedAt())
                .build();
    }
}
