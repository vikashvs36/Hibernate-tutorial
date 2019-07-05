package com.modal.has_A_RelationShip.oneToOne.Annotation.uniDirectional.RelationTable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username, password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_profile",
            joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "profile_id", referencedColumnName = "id")
            }
    )
    private Profile profile;

    public User() { }

    public User(String username, String password, Profile profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
