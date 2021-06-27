package one.digitalinovation.personapi.service;

import one.digitalinovation.personapi.dto.MessageResponseDTO;
import one.digitalinovation.personapi.dto.PersonDTO;
import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinovation.personapi.Utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDto();
        Person expectedSavePerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavePerson);

        MessageResponseDTO expectedSucessMessage = createdExpectedMessageResponse(expectedSavePerson.getId());
        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        assertEquals(expectedSucessMessage, sucessMessage);
    }

    private MessageResponseDTO createdExpectedMessageResponse(Long id) {
        return MessageResponseDTO.builder()
                .message("Created person with ID: " + id)
                .build();
    }
}
