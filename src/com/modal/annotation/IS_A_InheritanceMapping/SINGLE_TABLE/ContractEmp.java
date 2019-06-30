package com.modal.annotation.IS_A_InheritanceMapping.SINGLE_TABLE;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "contract_emp")
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
