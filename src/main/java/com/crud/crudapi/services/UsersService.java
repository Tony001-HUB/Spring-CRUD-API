package com.crud.crudapi.services;

import com.crud.crudapi.dtos.UserDto;
import com.crud.crudapi.exception.ResourceBadRequestException;
import com.crud.crudapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    public List<UserDto> usersList = new ArrayList<>() {{
        add(new UserDto("1", "Borys"));
        add(new UserDto("2", "Dima"));
        add(new UserDto("3", "Max"));
    }};

    public List<UserDto> getUsersList() {
        return this.usersList;
    }

    public UserDto getUserById(String id) {
        return this.usersList.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
    }

    public UserDto getUserByName(String name) {
        return this.usersList.stream()
                .filter(user -> name.equals(user.getName()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with name:" + name));
    }

    public UserDto deleteUser(String id) {
        UserDto foundUser = this.usersList.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        this.usersList.remove(foundUser);
        return foundUser;
    }

    public UserDto createUser(UserDto user) {
        UserDto foundUser = this.usersList.stream()
                .filter(currentUser ->
                        user.getId().equals(currentUser.getId()) ||
                        user.getName().equals(currentUser.getName())
                ).findFirst().orElse(null);
        if (foundUser != null) {
            throw new ResourceBadRequestException("The user already exists");
        }
        this.usersList.add(user);
        return user;
    }


    public UserDto updateUser(UserDto user) {
        UserDto foundUser = this.usersList.stream()
                .filter(currentUser -> user.getId().equals(currentUser.getId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + user.getId()));
        this.usersList.remove(foundUser);
        this.usersList.add(user);
        return user;
    }
}
