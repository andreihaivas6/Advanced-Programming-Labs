package com.example.Lab11.relationship;

import com.example.Lab11.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/relationship")
public class RelationshipController {
    private final RelationshipService relationshipService;

    @Autowired
    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @GetMapping
    public List<Relationship> getRelationships() {
        return relationshipService.getRelationships();
    }

    @PostMapping
    public void addRelationship(@RequestBody Relationship relationship) {
        relationshipService.addRelationship(relationship);
    }

    @GetMapping(path = "{numberOfPersons}")
    public List<Person> getKMostConnectedPersons(@PathVariable("numberOfPersons") Integer numberOfPersons) {
        return relationshipService.getKMostConnectedPersons(numberOfPersons);
    }
}
