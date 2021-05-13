package com.example.Lab11.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// lucreaza cu DB + JPA
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
