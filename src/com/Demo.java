package com;

import com.modal.annotation.Employee;
import com.modal.configuration.User;
import org.hibernate.*;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        /*System.out.print("Enter Name: ");
        String name=in.nextLine();
        in.close();
//        User user=new User(name);
        Employee emp=new Employee(name);
        System.out.println("Persiting com.modal.configuration.Employee object...");
        Session session=MyFactory.getSession();
        //Transaction is get started from the session
        Transaction t=session.beginTransaction();
        //Session is asked to save the entity
        session.save(emp);
        //transaction is get committed
        t.commit();
        System.out.println("Successfully saved.");*/

        System.out.println("Retrieving data from database .");
        Session session=MyFactory.getSession();
        //Session is asked to save the entity
        Employee get=session.get(Employee.class,2);
        System.out.println(get);
        Employee load=session.load(Employee.class,2);
        System.out.println(load);



        //session is closed
        session.close();
    }
}
