package com.learning.microservices.Entity.DTO;

public class PersonDTO {
    private String firstName;
    private String lastName;
    public PersonDTO()
    {

    }
    public PersonDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastNam) {
        this.lastName = lastNam;
    }
}
