package io.github.ryansilva.veticore.service.people.validate;

import io.github.ryansilva.veticore.repository.PeopleResitory;
import io.github.ryansilva.veticore.service.register.validate.ValidatePeopleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidatePeopleServiceTest {

    @InjectMocks
    private ValidatePeopleService tested;

    @Mock
    private PeopleResitory peopleResitory;

    @Test
    void shouldThrowErrorWhenCpfExists() {
        String peopleCpf = "00000000000";

        when(peopleResitory.existsByCpf(peopleCpf)).thenReturn(true);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> tested.existsByCpf(peopleCpf));

        verify(peopleResitory).existsByCpf(peopleCpf);

        assertEquals("Já existe um cadastro com este cpf.", exception.getReason());
    }

    @Test
    void shouldNotThrowErrorWhenCpfNotExists() {
        String peopleCpf = "00000000000";

        when(peopleResitory.existsByCpf(peopleCpf)).thenReturn(false);

        tested.existsByCpf(peopleCpf);

        verify(peopleResitory).existsByCpf(peopleCpf);
    }

    @Test
    void shouldThrowErrorWhenEmailExists() {
        String peopleEmail = "emailpeople123@gmail.com";

        when(peopleResitory.existsByEmail(peopleEmail)).thenReturn(true);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> tested.existsByEmail(peopleEmail));

        verify(peopleResitory).existsByEmail(peopleEmail);

        assertEquals("Já existe um cadastro com este e-mail.", exception.getReason());
    }

    @Test
    void shouldNotThrowErrorWhenEmailNotExists() {
        String peopleEmail = "emailpeople123@gmail.com";

        when(peopleResitory.existsByEmail(peopleEmail)).thenReturn(false);

        tested.existsByEmail(peopleEmail);

        verify(peopleResitory).existsByEmail(peopleEmail);
    }
}
