package com.crud.crudapi.services;

import com.crud.crudapi.exception.ResourceServerErrorException;
import com.crud.crudapi.modal.Person;
import com.crud.crudapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {
    private final String serverUnavailable = "The server is unavailable";

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Person> getAllUsers() {
        try {
            return this.userRepository.findAll();
        } catch (Exception  e) {
            throw new ResourceServerErrorException(this.serverUnavailable);
        }
    }

    public Person getUserByName(String name) {
        try {
            return this.userRepository.findByName(name);
        } catch (Exception  e) {
            throw new ResourceServerErrorException(this.serverUnavailable);
        }
    }

    public Person createUser(Person user) {
        try {
            return this.userRepository.save(user);
        } catch (Exception  e) {
            throw new ResourceServerErrorException(this.serverUnavailable);
        }
    }
}
