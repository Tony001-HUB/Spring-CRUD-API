package com.crud.crudapi.repository;

import com.crud.crudapi.modal.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);
}
