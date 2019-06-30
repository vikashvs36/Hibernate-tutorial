package com.modal.configuration.InheritanceMapping.TablePerHierarchy;

public class Student extends Person {

    private int fee;
    private String cource;

    public Student() { }

    public Student(int fee, String cource) {
        this.fee = fee;
        this.cource = cource;
    }

    public Student(String name, int fee, String cource) {
        super(name);
        this.fee = fee;
        this.cource = cource;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fee=" + fee +
                ", cource='" + cource + '\'' +
                "} " + super.toString();
    }
}
