package com.crud.crudapi.controller;

import com.crud.crudapi.exception.ResourceBadRequestException;
import com.crud.crudapi.modal.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crud.crudapi.services.UsersService;

import java.util.List;

@RestController()
@RequestMapping("v1/managers")
public class UsersController {

    public UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping
    public ResponseEntity<List<Person>> getUsersList() {
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public  ResponseEntity<Person> getUserByName(@PathVariable String name) {
        return new ResponseEntity<>(usersService.getUserByName(name), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Person> createUser(@RequestBody Person user) {
        if (user.getName() == null || user.getName().equals("")) {
            throw new ResourceBadRequestException("Name may not be blank");
        }
        return new ResponseEntity<>(usersService.createUser(user), HttpStatus.CREATED);
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
