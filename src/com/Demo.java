package com;

import com.modal.User;
import com.modal.UserDetails;
import org.hibernate.*;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name=in.nextLine();
        in.close();
        //com.modal.User object is created
        User user=new User(name);
        System.out.println("Persiting com.modal.User object...");
        Session session=MyFactory.getSession();
        //Transaction is get started from the session
        Transaction t=session.beginTransaction();
        //Session is asked to save the entity
        session.save(user);
        //transaction is get committed
        t.commit();
        //session is closed
        session.close();
        System.out.println("Successfully saved.");
    }
}
