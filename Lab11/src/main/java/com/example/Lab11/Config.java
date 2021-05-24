package com.example.Lab11;

import com.example.Lab11.person.Person;
import com.example.Lab11.person.PersonRepository;
import com.example.Lab11.relationship.Relationship;
import com.example.Lab11.relationship.RelationshipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
//@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
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

//    http://localhost:8081/swagger-ui-custom.html
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.Lab11"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(info());
    }

    private ApiInfo info() {
        return new ApiInfo(
                "Spring Boot Swagger Example API",
                "description",
                "1.0",
                "",
                "Dani Haivas",
                "", ""
        );
    }
}
