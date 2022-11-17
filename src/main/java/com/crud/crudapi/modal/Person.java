package com.crud.crudapi.modal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank
    private String name;
    private String info;

    public Person() {
    }

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
}
