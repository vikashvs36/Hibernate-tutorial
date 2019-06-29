package com.modal;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

// UserDetails domain is created to know basic Hibernate Annotation how to use.
@Entity         // Entity annotation is help to create new table as class name
@Table(name = "user_details") // Table annotation is help to create different table name from the domain.
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // To Generated automatic new id
    private int id;
    @Column(name = "address")
    private String currntAddress;
    // Transient annotation is used to not create column in db.
    @Transient
    private boolean haveAnyPet;

    public UserDetails() { }

    public UserDetails(String currntAddress) {
        this.currntAddress = currntAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return currntAddress;
    }

    public void setAddress(String currntAddress) {
        this.currntAddress= currntAddress;
    }

    public boolean getHaveAnyPet() {
        return haveAnyPet;
    }

    public void setHaveAnyPet(boolean haveAnyPet) {
        this.haveAnyPet = haveAnyPet;
    }
}
