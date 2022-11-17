package com.crud.crudapi.services;

import com.crud.crudapi.exception.ResourceServerErrorException;
import com.crud.crudapi.modal.Person;
import com.crud.crudapi.modal.response.PersonResponse;
import com.crud.crudapi.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final String serverUnavailable = "The server is unavailable";

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonResponse> getAllUsers() {
        try {
            ArrayList<PersonResponse> personResponses = new ArrayList<>();
            personRepository.findAll().forEach(person -> personResponses.add(new PersonResponse(person.getId(), person.getName(), person.getInfo())));
            return personResponses;
        } catch (Exception e) {
            throw new ResourceServerErrorException(this.serverUnavailable);
        }
    }

    public Person getUserByName(String name) {
        try {
            return this.personRepository.findByName(name);
        } catch (Exception e) {
            throw new ResourceServerErrorException(this.serverUnavailable);
        }
    }

    public Person createUser(Person person) {
        try {
            return this.personRepository.save(person);
        } catch (Exception e) {
            throw new ResourceServerErrorException(this.serverUnavailable);
        }
    }

    public HttpStatus deleteUser(String id) {
        try {
            this.personRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new ResourceServerErrorException(this.serverUnavailable);
        }
    }
}
