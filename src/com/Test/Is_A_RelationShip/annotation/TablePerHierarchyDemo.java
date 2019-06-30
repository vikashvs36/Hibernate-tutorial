package com.Test.Is_A_RelationShip.annotation;

import com.Dao.UserDao;
import com.modal.annotation.IS_A_InheritanceMapping.SINGLE_TABLE.*;

public class TablePerHierarchyDemo {

    public static void main(String[] args) {

        Emp emp=new Emp("Test");
        ContractEmp contractEmp=new ContractEmp("Vikash", "Trainee", 18000);
        RegularEmp regularEmp=new RegularEmp("Singh", "Software Developer",25000, 500);

        UserDao.save(emp);
        UserDao.save(contractEmp);
        UserDao.save(regularEmp);

        System.out.println("Data Saved");
    }
}
