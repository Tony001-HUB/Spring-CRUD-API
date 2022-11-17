package com.crud.crudapi.controller;

import com.crud.crudapi.exception.ResourceBadRequestException;
import com.crud.crudapi.modal.Person;
import com.crud.crudapi.modal.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crud.crudapi.services.PersonService;

import java.util.List;

@RestController()
@RequestMapping("v1/managers")
public class PersonController {

    public PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping
    public ResponseEntity<List<PersonResponse>> getUsersList() {
        return new ResponseEntity<>(personService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public  ResponseEntity<Person> getUserByName(@PathVariable String name) {
        return new ResponseEntity<>(personService.getUserByName(name), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Person> createUser(@RequestBody Person person) {
        if (person.getName() == null || person.getName().equals("")) {
            throw new ResourceBadRequestException("Name may not be blank");
        }
        return new ResponseEntity<>(personService.createUser(person), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable String id) {
        return new ResponseEntity<>(personService.deleteUser(id), HttpStatus.OK);
    }

    /*
    @RequestMapping(
            params = { "id" },
            method = GET
    )
    @ResponseBody
    public UserDto getUserById(@RequestParam("id") String id) {
        return this.usersService.getUserById(id);
    }

    @RequestMapping(
            params = { "name" },
            method = GET
    )
    @ResponseBody
    public UserDto getUserByName(@RequestParam("name") String name) {
        return this.usersService.getUserByName(name);
    }

    @DeleteMapping("{id}")
    public UserDto deleteUser(@PathVariable String id) {
        return this.usersService.deleteUser(id);
    }

    @PostMapping()
    public UserDto createUser(@RequestBody UserDto user) {
        return this.usersService.createUser(user);
    }

    @PutMapping()
    public UserDto updateUser(@RequestBody UserDto user) {
        return this.usersService.updateUser(user);
    }
     */
}
