package com.modal.has_A_RelationShip.oneToOne.Annotation.uniDirectional.RelationTable;


import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue
    private int id;
    private String address;

    public Profile() { }

    public Profile(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
