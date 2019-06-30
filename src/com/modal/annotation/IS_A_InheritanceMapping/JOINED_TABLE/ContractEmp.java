package com.modal.annotation.IS_A_InheritanceMapping.JOINED_TABLE;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "contract_emp")
@PrimaryKeyJoinColumn(name = "id")
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
