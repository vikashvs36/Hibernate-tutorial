package com.modal.configuration.InheritanceMapping;

public class Emp extends Person {

    private String job;
    private long salary;

    public Emp() { }

    public Emp(String job, long salary) {
        this.job = job;
        this.salary = salary;
    }

    public Emp(String name, String job, long salary) {
        super(name);
        this.job = job;
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "job='" + job + '\'' +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
