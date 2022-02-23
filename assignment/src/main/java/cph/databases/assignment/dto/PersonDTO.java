package cph.databases.assignment.dto;

import cph.databases.assignment.entity.Person;

public class PersonDTO {

    private Person person;
    private String firstName;

    // Constructor
    public PersonDTO(Person person) {
        this.firstName = person.getFirstName();
    }
}
