package com.learning.microservices.controller;

import com.learning.microservices.Entity.DTO.PersonDTO;
import com.learning.microservices.Entity.Person;
import com.learning.microservices.Repository.PersonRepository;
import com.learning.microservices.converter.PersonConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {
    private PersonRepository personRepository;
    private PersonConverter personConverter;

    public PersonController(PersonRepository personRepository,PersonConverter personConverter) {
        this.personRepository=personRepository;
        this.personConverter = personConverter;
    }
    @GetMapping("/persons/{id}")
    public PersonDTO getPersonById(int id)
    {
        Person person=personRepository.findById(id).orElse(null);
        return personConverter.convertToDTO(person);
    }
    @GetMapping("/persons")
    public List<PersonDTO> getAll()
    {
        List<Person> person=  personRepository.findAll();
        List<PersonDTO> personDTOList=person.stream().map(personConverter::convertToDTO).collect(Collectors.toList());
        return  personDTOList;
    }

    @PostMapping("/persons")
    public void savePerson(PersonDTO personDTO)
    {
        Person person=personConverter.convertToEntity(personDTO);
        personRepository.save(person);
    }
    @DeleteMapping("/persons/{id}")
    public void deleteById(@PathVariable int id)
    {
        personRepository.deleteById(id);
    }
    @PutMapping("/person/{id}")
    public PersonDTO updatePerson(@PathVariable int id,@RequestBody PersonDTO updatedPersonDTO)
    {
        Person person=personRepository.findById(id).orElse(null);
        if(person!=null)
        {
            person.setFirstName(updatedPersonDTO.getFirstName());
            person.setLastName(updatedPersonDTO.getLastNam());
            personRepository.save(person);
            PersonDTO updatedPerson=personConverter.convertToDTO(person);
            return updatedPerson;
        }
        return null;
    }
}
