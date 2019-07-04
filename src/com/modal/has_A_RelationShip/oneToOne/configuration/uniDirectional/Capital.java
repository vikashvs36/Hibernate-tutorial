package com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional;

public class Capital {

    private int id;
    private String name;

    public Capital() { }

    public Capital(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
