package com.crud.crudapi.controller;

import com.crud.crudapi.dtos.UserDto;
import org.springframework.web.bind.annotation.*;
import com.crud.crudapi.services.UsersService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
@RequestMapping("users")
public class UsersController {
    public UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping
    public List<UserDto> getUsersList() {
        return this.usersService.getUsersList();
    }

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

}
