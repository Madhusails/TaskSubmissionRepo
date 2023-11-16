package com.learning.microservices.converter;

import com.learning.microservices.Entity.DTO.PersonDTO;
import com.learning.microservices.Entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {
    public PersonDTO convertToDTO(Person person)
    {
        PersonDTO personDTO=new PersonDTO();
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastNam(person.getLastName());
        return personDTO;
    }

    public Person convertToEntity(PersonDTO personDTO)
    {
        Person person=new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastNam());
        return person;
    }
}
