package com.Test;

import com.Dao.UserDao;
import com.Factory.MyFactory;
import com.modal.configuration.InheritanceMapping.TablePerHierarchy.Emp;
import com.modal.configuration.InheritanceMapping.TablePerHierarchy.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TablePerHierarchyDemo {

    public static void main(String[] args) {

        Student student=new Student("vikash", 18000,"Java");
        Emp emp=new Emp("vikash", "Software Developer",15000);

        UserDao.save(student);
        UserDao.save(emp);

        System.out.println("Data Saved");
    }
}
