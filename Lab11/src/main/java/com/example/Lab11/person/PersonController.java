package com.example.Lab11.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// requests
@RestController
@RequestMapping(path = "api/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable Long personId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        personService.updatePerson(personId, firstName, lastName);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
    }
}
