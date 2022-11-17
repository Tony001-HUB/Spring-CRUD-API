package com.crud.crudapi.modal.response;

public class ContactDto {
    public String phoneNumber;
    public String address;

    public ContactDto(String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
