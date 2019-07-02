package com.modal.Embeded;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "state", column = @Column(name = "home_state")),
            @AttributeOverride(name = "country", column = @Column(name = "home_country")),
            @AttributeOverride(name = "pincode", column = @Column(name = "home_pincode"))
    })
    private Address home_address;
    @Embedded
    private Address office_address;

    public User() { }

    public User(String username, String password, Address home_address, Address office_address) {
        this.username = username;
        this.password = password;
        this.home_address= home_address;
        this.office_address= office_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getHome_address() {
        return home_address;
    }

    public void setHome_address(Address home_address) {
        this.home_address = home_address;
    }

    public Address getOffice_address() {
        return office_address;
    }

    public void setOffice_address(Address office_address) {
        this.office_address = office_address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", home_address=" + home_address +
                ", office_address=" + office_address +
                '}';
    }
}
