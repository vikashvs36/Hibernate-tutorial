package com;

import com.modal.User;
import org.hibernate.*;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter EmpName: ");
        String n=in.nextLine();
        in.close();
        //com.modal.User object is created
        User e=new User(n);
        System.out.println("Persiting com.modal.User object...");
        Session session=MyFactory.getSession();
        //Transaction is get started from the session
        Transaction t=session.beginTransaction();
        //Session is asked to save the entity
        session.save(e);
        //transaction is get committed
        t.commit();
        //session is closed
        session.close();
        System.out.println("Successfully saved.");
    }
}
