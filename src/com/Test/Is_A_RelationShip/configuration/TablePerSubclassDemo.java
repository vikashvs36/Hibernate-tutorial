package com.Test.Is_A_RelationShip.configuration;

import com.Dao.UserDao;
import com.modal.configuration.InheritanceMapping.IS_A.Emp;
import com.modal.configuration.InheritanceMapping.IS_A.Student;

public class TablePerSubclassDemo {

    public static void main(String[] args) {
        Student student=new Student("vikash", 18000,"Java");
        Emp emp=new Emp("Singh", "Software Developer",15000);

        UserDao.save(student);
        UserDao.save(emp);

        System.out.println("Data Saved");
    }
}
