package com.modal.annotation.IS_A_InheritanceMapping.TABLE_PER_CLASS;

import javax.persistence.*;

@Entity
@Table(name = "regular_emp")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="name", column=@Column(name="name"))
})
public class RegularEmp extends Emp {

    private String job;
    private long salary;
    private double bonus;

    public RegularEmp() { }

    public RegularEmp(String name, String job, long salary, double bonus) {
        super(name);
        this.job = job;
        this.salary = salary;
        this.bonus=bonus;
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

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
