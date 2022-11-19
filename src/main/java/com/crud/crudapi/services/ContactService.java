package com.crud.crudapi.services;

import com.crud.crudapi.constants.ConstantsHelper;
import com.crud.crudapi.exception.ResourceServerErrorException;
import com.crud.crudapi.modal.Contact;
import com.crud.crudapi.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(Contact contact) {
        try {
            return this.contactRepository.save(contact);
        } catch (Exception e) {
            throw new ResourceServerErrorException(ConstantsHelper.serverUnavailable);
        }
    }
}
