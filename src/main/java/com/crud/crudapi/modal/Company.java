package com.crud.crudapi.modal;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String companyName;

    @OneToMany(mappedBy="company",  cascade=CascadeType.ALL)
    private Collection<Person> person;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
