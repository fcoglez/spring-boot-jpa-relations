package com.springboot.jpa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //Con el orphan a true, hacemos que cuando se elimine un registro, en vez de que los valores se queden nulos, borra directamente los campos de la tabla
    private List<Address> addresses;

    public Client() {
        addresses = new ArrayList<>();
    }

    public Client(String name, String surname) {
        this(); //Llama al constructor vacio
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
