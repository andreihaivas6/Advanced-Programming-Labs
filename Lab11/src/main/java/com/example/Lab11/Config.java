package com.example.Lab11;

import com.example.Lab11.person.Person;
import com.example.Lab11.person.PersonRepository;
import com.example.Lab11.relationship.Relationship;
import com.example.Lab11.relationship.RelationshipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean // asta ruleaza la inceput
    CommandLineRunner commandLineRunner(PersonRepository personRepository,
                                        RelationshipRepository relationshipRepository) {
        return args -> {
            Person person1 = new Person(1L, "Ion", "Ionescu");
            Person person2 = new Person("George", "Popescu");
            Person person3 = new Person("Jme", "Keru");

            person1.increaseNumberOfRelationships();
            person2.increaseNumberOfRelationships();

            personRepository.saveAll(Arrays.asList(person1, person2, person3));
            personRepository.saveAll(List.of(person1, person2, person3));

            Relationship relationship = new Relationship(1L, 2L);
            relationshipRepository.save(relationship);
        };
    }
}
