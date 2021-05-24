package com.example.Lab11.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.List;

// Business Logic
@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addPerson(Person person) {
        if(person.getId() != null && personRepository.existsById(person.getId())) {
            throw new IllegalStateException("Id-ul deja exista");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        if(!personRepository.existsById(personId)) {
            throw new IllegalStateException("Person doesn't exist");
        }
        personRepository.deleteById(personId);
    }

    @Transactional // permite sa folosesti set si get din clasa Student in loc sa scrii interogari sql
    public void updatePerson(Long personId, String firstName, String lastName) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalStateException("Person doesn't exist"));

        if(firstName != null) {
            person.setFirstName(firstName);
        }
        if(lastName != null) {
            person.setLastName(lastName);
        }
    }

    @ExceptionHandler
    public String handleIllegalStateException(IllegalStateException exception) {
        return exception.getMessage();
    }

}
