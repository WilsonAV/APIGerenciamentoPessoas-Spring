package one.digitalinovation.personapi.controller;

import one.digitalinovation.personapi.dto.MessageResponseDTO;
import one.digitalinovation.personapi.dto.PersonDTO;
import one.digitalinovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

}
