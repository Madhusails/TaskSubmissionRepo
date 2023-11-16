package com.learning.microservices.controller;

import com.learning.microservices.Entity.DTO.PersonDTO;
import com.learning.microservices.Entity.Person;
import com.learning.microservices.Repository.PersonRepository;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {
    private PersonRepository personRepository;
    private ModelMapper modelMapper;

    public PersonController(PersonRepository personRepository,ModelMapper modelMapper) {
        this.personRepository=personRepository;
        this.modelMapper= modelMapper;
    }
    @GetMapping("/persons/{id}")
    public PersonDTO getPersonById(int id)
    {
        Person person=personRepository.findById(id).orElse(null);
        return modelMapper.map(person,PersonDTO.class);
    }
    @GetMapping("/persons")
    public List<PersonDTO> getAll()
    {
        List<Person> person=  personRepository.findAll();
        List<PersonDTO> personDTOList=person.stream().map(p->modelMapper.map(p,PersonDTO.class)).collect(Collectors.toList());
        return  personDTOList;
    }

    @PostMapping("/persons")
    public void savePerson(PersonDTO personDTO)
    {
        Person person=modelMapper.map(personDTO,Person.class);
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
            person.setLastName(updatedPersonDTO.getLastName());
            personRepository.save(person);
            PersonDTO updatedPerson=modelMapper.map(person,PersonDTO.class);
            return updatedPerson;
        }
        return null;
    }
    @GetMapping("/person/{firstName}")
    public PersonDTO getPersonByFirstName(@PathVariable String firstName)
    {
        Person person= personRepository.findByFirstName(firstName);
        return modelMapper.map(person,PersonDTO.class);
    }
}
