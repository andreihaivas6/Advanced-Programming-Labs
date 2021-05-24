package com.example.Lab11.relationship;

import com.example.Lab11.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping
//    public List<Relationship> getRelationships() {
//        return relationshipService.getRelationships();
//    }
//    @PostMapping
//    public void addRelationship(@RequestBody Relationship relationship) {
//      relationshipService.addRelationship(relationship);
//    }
//
//    @GetMapping(path = "{numberOfPersons}")
//    public List<Person> getKMostConnectedPersons(@PathVariable("numberOfPersons") Integer numberOfPersons) {
//        return relationshipService.getKMostConnectedPersons(numberOfPersons);
//    }
//
//    @GetMapping("/mostImportant")
//    public List<Person> getMostImportant() {
//        return relationshipService.getMostImportant();
//    }


    @GetMapping
    public ResponseEntity<?> getRelationships() {
        return new ResponseEntity<>(relationshipService.getRelationships(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addRelationship(@RequestBody Relationship relationship) {
        relationshipService.addRelationship(relationship);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "{numberOfPersons}")
    public ResponseEntity<?> getKMostConnectedPersons(@PathVariable("numberOfPersons") Integer numberOfPersons) {
        return new ResponseEntity<>(relationshipService.getKMostConnectedPersons(numberOfPersons), HttpStatus.OK);
    }

    @GetMapping("/mostImportant")
    public ResponseEntity<?> getMostImportant() {
        return new ResponseEntity<>(relationshipService.getMostImportant(), HttpStatus.OK);
    }
}
