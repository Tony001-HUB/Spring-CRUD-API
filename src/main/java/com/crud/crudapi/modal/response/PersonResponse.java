package com.crud.crudapi.modal.response;

public class PersonResponse {
    public Long id;
    public String name;
    public String info;

    public PersonResponse(Long id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }
}
