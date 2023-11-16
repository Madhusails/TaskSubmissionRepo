package com.learning.microservices.Entity.DTO;

public class PersonDTO {
    private String firstName;
    private String lastNam;
    public PersonDTO()
    {

    }
    public PersonDTO(String firstName, String lastNam) {
        this.firstName = firstName;
        this.lastNam = lastNam;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNam() {
        return lastNam;
    }

    public void setLastNam(String lastNam) {
        this.lastNam = lastNam;
    }
}
