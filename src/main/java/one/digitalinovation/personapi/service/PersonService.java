package one.digitalinovation.personapi.service;

import one.digitalinovation.personapi.dto.MessageResponseDTO;
import one.digitalinovation.personapi.dto.PersonDTO;
import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.mapper.PersonMapper;
import one.digitalinovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;



    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }


}
