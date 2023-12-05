package com.learning.microservices.person;

import com.learning.microservices.Entity.DTO.PersonDTO;
import com.learning.microservices.Entity.Person;
import com.learning.microservices.Repository.PersonRepository;
import com.learning.microservices.controller.PersonController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonControllerTest {
    @Mock
    private PersonRepository personRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PersonController personController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPersonById() {
        // Implement test for getPersonById method
        // Use when().thenReturn() to mock the behavior of the dependencies
        int personId = 101;
        Person mockedPerson = new Person();  // Create a mocked Person object
        PersonDTO expectedPersonDTO = new PersonDTO();  // Create a mocked PersonDTO object

        // Mock the behavior of dependencies
        when(personRepository.findById(personId)).thenReturn(java.util.Optional.ofNullable(mockedPerson));
        when(modelMapper.map(mockedPerson, PersonDTO.class)).thenReturn(expectedPersonDTO);

        // Act
        PersonDTO resultPersonDTO = personController.getPersonById(personId);

        // Assert
        assertEquals(expectedPersonDTO, resultPersonDTO);
    }

    @Test
    public void testGetAll() {
        // Implement test for getAll method
    }

    @Test
    public void testSavePerson() {
        // Implement test for savePerson method
    }

    @Test
    public void testDeleteById() {
        // Implement test for deleteById method
        // Use verify() to verify that the deleteById method of the repository is called
        int personId=1;
        Person person=new Person();
        PersonDTO personDTO=new PersonDTO();
        when(personRepository.findById(personId)).thenReturn(Optional.of(person));

    }

    @Test
    public void testUpdatePerson() {
        // Implement test for updatePerson method
    }

    @Test
    public void testGetPersonByFirstName() {
        // Implement test for getPersonByFirstName method
    }
}
