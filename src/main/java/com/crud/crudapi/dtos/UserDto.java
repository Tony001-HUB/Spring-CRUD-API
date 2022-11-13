package com.crud.crudapi.dtos;

public class UserDto {
    public String id;
    public String name;

    public UserDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

}
