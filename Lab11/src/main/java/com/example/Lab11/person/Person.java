package com.example.Lab11.person;

import javax.persistence.*;

@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private Integer numberOfRelationships;

    public Person() { }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfRelationships = 0;
    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfRelationships = 0;
    }

    public void increaseNumberOfRelationships() {
        numberOfRelationships++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfRelationships() {
        return numberOfRelationships;
    }

    public void setNumberOfRelationships(Integer numberOfRelationships) {
        this.numberOfRelationships = numberOfRelationships;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberOfRelationships=" + numberOfRelationships +
                '}';
    }
}
