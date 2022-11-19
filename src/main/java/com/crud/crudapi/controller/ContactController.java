package com.crud.crudapi.controller;

import com.crud.crudapi.modal.Contact;
import com.crud.crudapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/contacts")
public class ContactController {
    public ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping()
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.createContact(contact), HttpStatus.CREATED);
    }
}
