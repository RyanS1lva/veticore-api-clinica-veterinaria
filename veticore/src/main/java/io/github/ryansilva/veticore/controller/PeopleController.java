package io.github.ryansilva.veticore.controller;

import io.github.ryansilva.veticore.controller.request.people.RegisterPeopleRequest;
import io.github.ryansilva.veticore.controller.response.people.PeopleResponse;
import io.github.ryansilva.veticore.service.register.RegisterPeopleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/people")
public class PeopleController {

    private final RegisterPeopleService registerPeopleService;

    @PostMapping
    public PeopleResponse register(@Valid @RequestBody RegisterPeopleRequest request) {
        return registerPeopleService.register(request);
    }
}
