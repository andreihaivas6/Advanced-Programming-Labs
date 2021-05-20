package com.example.Lab11.relationship;

import com.example.Lab11.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelationshipService {
    private final RelationshipRepository relationshipRepository;

    @Autowired
    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    public List<Relationship> getRelationships() {
        return relationshipRepository.findAll();
    }

//    @Transactional
    public void addRelationship(Relationship relationship) {
        if(relationshipRepository.findAll().contains(relationship)) {
            throw new IllegalStateException("Relationship already exists.");
        }

        Person person1 = relationshipRepository.getPersonsWithId(relationship.getIdPerson1());
        Person person2 = relationshipRepository.getPersonsWithId(relationship.getIdPerson2());
        if (person1 == null || person2 == null || relationship.getIdPerson1().equals(relationship.getIdPerson2())) {
            throw new IllegalStateException("Bad IDs.");
        }

        person1.increaseNumberOfRelationships();
        person2.increaseNumberOfRelationships();
        relationshipRepository.save(relationship);

//        Optional<Person> getPersonWithId(int id);
//        Person person1 = relationshipRepository.getPersonsWithId(relationship.getIdPerson1())
//                .orElseThrow(() -> new IllegalStateException("Person with this id doesn't exist."));
    }

    public List<Person> getKMostConnectedPersons(Integer numberOfPersons) {
        List<Person> topConnected = relationshipRepository.getMostConnectedPersons();
        List<Person> result = new ArrayList<>();

        for(int i = 0; i < numberOfPersons && i < topConnected.size(); ++i) {
            result.add(topConnected.get(i));
        }
        return result;
    }

    @ExceptionHandler
    public String handleIllegalStateException(IllegalStateException exception) {
        return exception.getMessage();
    }
}
