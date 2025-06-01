package io.github.ryansilva.veticore.service.people;

import io.github.ryansilva.veticore.controller.request.people.RegisterPeopleRequest;
import io.github.ryansilva.veticore.controller.response.people.PeopleResponse;
import io.github.ryansilva.veticore.model.People;
import io.github.ryansilva.veticore.repository.PeopleResitory;
import io.github.ryansilva.veticore.service.register.RegisterPeopleService;
import io.github.ryansilva.veticore.service.register.validate.ValidatePeopleService;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith({MockitoExtension.class, InstancioExtension.class})
public class RegisterPeopleServiceTest {

    @InjectMocks
    private RegisterPeopleService tested;

    @Mock
    private PeopleResitory peopleResitory;

    @Mock
    private ValidatePeopleService validatePeopleService;

    @Captor
    private ArgumentCaptor<People> peopleCaptor;

    @Test
    void shouldRegisterPeopleWithSuccess() {
        RegisterPeopleRequest request = Instancio.of(RegisterPeopleRequest.class).create();

        PeopleResponse response = tested.register(request);

        verify(validatePeopleService).existsByCpf(request.getCpf());
        verify(validatePeopleService).existsByEmail(request.getEmail());

        verify(peopleResitory).save(peopleCaptor.capture());

        People peopleSaved = peopleCaptor.getValue();

        assertNotNull(response);
        assertEquals(request.getName(), peopleSaved.getName());
        assertEquals(request.getEmail(), peopleSaved.getEmail());
        assertEquals(request.getCpf(), peopleSaved.getCpf());
        assertEquals(request.getPhone(), peopleSaved.getPhone());
    }
}
