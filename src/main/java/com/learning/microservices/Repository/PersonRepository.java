package com.learning.microservices.Repository;

import com.learning.microservices.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query("SELECT p FROM Person p WHERE p.firstName = :firstName")
    Person findByFirstName(@Param("firstName") String firstName);

}
