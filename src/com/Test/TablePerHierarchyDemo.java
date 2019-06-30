package com.Test;

import com.Dao.UserDao;
import com.modal.configuration.InheritanceMapping.Emp;
import com.modal.configuration.InheritanceMapping.Student;

public class TablePerHierarchyDemo {

    public static void main(String[] args) {

        Student student=new Student("vikash", 18000,"Java");
        Emp emp=new Emp("vikash", "Software Developer",15000);

        UserDao.save(student);
        UserDao.save(emp);

        System.out.println("Data Saved");
    }
}
