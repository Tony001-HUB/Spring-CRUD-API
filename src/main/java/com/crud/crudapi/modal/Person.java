package com.crud.crudapi.modal;

import com.crud.crudapi.modal.response.ContactDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank
    @Column
    private String name;
    @Column
    private String info;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="contact_id")
    private Contact contact;

    @ManyToOne (cascade=CascadeType.ALL)
    @JoinColumn (name="company_id")
    private Company company;
    public Person() {}

    public Person(String title, String text) {
        this.name = title;
        this.info = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String text) {
        this.info = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
