package com.example.Lab11.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean // asta ruleaza la inceput
    CommandLineRunner commandLineRunner(PersonRepository personRepository) {
        return args -> {
            Person person1 = new Person(1L, "Ion", "Ionescu");
            Person person2 = new Person("George", "Popescu");

            personRepository.saveAll(List.of(person1, person2));
        };
    }
}
