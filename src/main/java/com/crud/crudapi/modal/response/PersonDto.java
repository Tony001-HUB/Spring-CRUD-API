package com.crud.crudapi.modal.response;

import com.crud.crudapi.modal.Contact;

public class PersonDto {
    public Long id;
    public String name;
    public String info;
    public ContactDto contact;

    public PersonDto(Long id, String name, String info, ContactDto contactDto) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.contact = contactDto;
    }
}
