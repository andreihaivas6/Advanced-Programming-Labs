package com.example.Lab11.relationship;

import com.example.Lab11.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    @Query("SELECT p FROM Person p WHERE p.id = ?1")
    Person getPersonsWithId(Long id);

    @Query("SELECT p FROM Person p ORDER BY p.numberOfRelationships DESC")
    List<Person> getMostConnectedPersons();

    @Query("SELECT p FROM Person p")
    List<Person> getPersons();
}
