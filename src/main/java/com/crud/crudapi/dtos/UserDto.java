package com.crud.crudapi.dtos;

public class UserDto {
    private String _id;
    private String _name;

    public UserDto(String id, String name) {
        _id = id;
        _name = name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public String getId() {
        return _id;
    }
}
