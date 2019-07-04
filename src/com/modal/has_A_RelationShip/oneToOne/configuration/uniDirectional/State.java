package com.modal.has_A_RelationShip.oneToOne.configuration.uniDirectional;

public class State {

    private int id;
    private String name;
    private Capital capital;

    public State() { }

    public State(String name, Capital capital) {
        this.name = name;
        this.capital=capital;
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

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }
}
