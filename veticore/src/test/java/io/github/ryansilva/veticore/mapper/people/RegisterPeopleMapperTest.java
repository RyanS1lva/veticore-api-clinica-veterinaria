package io.github.ryansilva.veticore.mapper.people;

import io.github.ryansilva.veticore.controller.request.people.RegisterPeopleRequest;
import io.github.ryansilva.veticore.model.People;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InstancioExtension.class)
public class RegisterPeopleMapperTest {

    @Test
    void shouldReturnPeople() {
        RegisterPeopleRequest request = Instancio.of(RegisterPeopleRequest.class).create();

        People people = RegisterPeopleMapper.toEntity(request);

        Assertions.assertNotNull(people);
        Assertions.assertNull(people.getId());
        Assertions.assertEquals(request.getName(), people.getName());
        Assertions.assertEquals(request.getPhone(), people.getPhone());
        Assertions.assertEquals(request.getCpf(), people.getCpf());
        Assertions.assertEquals(request.getEmail(), people.getEmail());
    }
}
