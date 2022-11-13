package com.crud.crudapi.services;

import com.crud.crudapi.dtos.UserDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

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
                .findAny()
                .orElse(null);
    }
}
