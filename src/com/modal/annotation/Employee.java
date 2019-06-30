package com.modal.annotation;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

// UserDetails domain is created to know basic Hibernate Annotation how to use.
@Entity         // Entity annotation is help to create new table as class name
@Table(name = "emp") // Table annotation is help to create different table name from the domain.
public class Employee {

    @Id                                                 // @Id annotation marks the identifier for this entity.
    @GeneratedValue(strategy = GenerationType.AUTO)     // To Generated automatic new id
    private int id;
    @Column(name = "username")
    private String userName;
    // Transient annotation is used to not create column in db.
    @Transient
    private boolean isMarried;

    public Employee() { }

    public Employee(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }
}
