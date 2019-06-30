package com.modal.annotation.IS_A_InheritanceMapping.TABLE_PER_CLASS;

import javax.persistence.*;

@Entity
@Table(name = "contract_emp")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="name", column=@Column(name="name"))
})
public class ContractEmp extends Emp {

    private String job;
    private long salary;

    public ContractEmp() { }

    public ContractEmp(String name, String job, long salary) {
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

}
