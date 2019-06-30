package com.Test;

import com.Dao.UserDao;
import com.modal.configuration.InheritanceMapping.IS_A.Emp;
import com.modal.configuration.InheritanceMapping.IS_A.Student;

public class TablePerHierarchyDemo {

    public static void main(String[] args) {

        Student student=new Student("Vikash", 18000,"Java");
        Emp emp=new Emp("Singh", "Software Developer",15000);

        UserDao.save(student);
        UserDao.save(emp);

        System.out.println("Data Saved");
    }
}
