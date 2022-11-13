package com.crud.crudapi.controller;

import com.crud.crudapi.dtos.UserDto;
import org.springframework.web.bind.annotation.*;
import com.crud.crudapi.services.UsersService;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("users")
public class UsersController {
    public UsersService usersService;

    @GetMapping
    public List<UserDto> getUsersList() {
        return this.usersService.getUsersList();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return this.usersService.getUserById(id);
    }
}
