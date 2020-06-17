package com.globallogic.people.management.repository;

import com.globallogic.people.management.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findById(long id);
}
