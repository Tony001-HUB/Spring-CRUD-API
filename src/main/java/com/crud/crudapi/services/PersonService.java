package com.crud.crudapi.services;

import com.crud.crudapi.constants.ConstantsHelper;
import com.crud.crudapi.exception.ResourceServerErrorException;
import com.crud.crudapi.modal.Company;
import com.crud.crudapi.modal.Person;
import com.crud.crudapi.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final CompanyService companyService;

    public PersonService(PersonRepository personRepository, CompanyService companyService) {
        this.personRepository = personRepository;
        this.companyService = companyService;
    }

    public List<Person> getAllUsers() {
        try {
            return personRepository.findAll();
            /*
            ArrayList<PersonDto> personResponse = new ArrayList<>();
            personRepository.findAll().forEach(person ->
                    personResponse.add(
                            new PersonDto(
                                    person.getId(),
                                    person.getName(),
                                    person.getInfo(),
                                    new ContactDto(person.getContact().getPhoneNumber(), person.getContact().getAddress())
                            ))
                    );
            return personResponse;
            */
        } catch (Exception e) {
            throw new ResourceServerErrorException(ConstantsHelper.serverUnavailable);
        }
    }

    public Person getUserByName(String name) {
        try {
            return this.personRepository.findByName(name);
        } catch (Exception e) {
            throw new ResourceServerErrorException(ConstantsHelper.serverUnavailable);
        }
    }

    public Person createUser(Person person) {
        try {
            return this.personRepository.save(person);
        } catch (Exception e) {
            throw new ResourceServerErrorException(ConstantsHelper.serverUnavailable);
        }
    }

    public HttpStatus deleteUser(String id) {
        try {
            this.personRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new ResourceServerErrorException(ConstantsHelper.serverUnavailable);
        }
    }

    public Person addCompanyToUser(Long personId, Long companyId) {
        try {
            Person person = this.personRepository.getPersonById(personId);
            Company company = this.companyService.getCompanyById(companyId);
            if (person.getId() == null) {
                throw new ResourceServerErrorException(ConstantsHelper.userNotFound + personId);
            }
            if (company.getId() == null) {
                throw new ResourceServerErrorException(ConstantsHelper.companyNotFound + companyId);
            }
            person.setCompany(company);
            return this.personRepository.save(person);
        } catch (Exception e) {
            throw new ResourceServerErrorException(ConstantsHelper.serverUnavailable);
        }
    }
}
