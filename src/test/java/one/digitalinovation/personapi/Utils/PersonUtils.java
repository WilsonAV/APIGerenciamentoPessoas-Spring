package one.digitalinovation.personapi.Utils;

import one.digitalinovation.personapi.dto.PersonDTO;
import one.digitalinovation.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Wilson";
    private static final String LAST_NAME = "Nunes";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final  long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10,5);

    public static PersonDTO createFakeDto(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
