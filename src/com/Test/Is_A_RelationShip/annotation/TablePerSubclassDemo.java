package com.Test.Is_A_RelationShip.annotation;

import com.Dao.UserDao;
import com.modal.annotation.IS_A_InheritanceMapping.JOINED_TABLE.*;

public class TablePerSubclassDemo {

    public static void main(String[] args) {
        ContractEmp contractEmp=new ContractEmp("Vikash", "Trainee", 18000);
        RegularEmp regularEmp=new RegularEmp("Singh", "Software Developer",25000, 500);

        UserDao.save(contractEmp);
        UserDao.save(regularEmp);

        System.out.println("Data Saved");
    }
}
