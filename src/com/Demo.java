package com;

import com.Dao.UserDao;
import com.modal.annotation.Employee;
import com.modal.configuration.User;
import org.hibernate.*;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String name=null;
        User user=null;

        System.out.println("\nSave Data into Database.");
        System.out.println("Enter Name : ");
        name=in.nextLine();
        UserDao.save(new User(name));       // Save new User into db.


        System.out.println("\n\nRetrieving data from database.");
        System.out.println("Please enter user id : ");
        int id=in.nextInt();
        user= UserDao.get(id);         // Retrieve User if exist.
        if (user != null) {
            System.out.println("Name : "+user.getName());
        }

        System.out.println("\n\nUpdating data from database .");
        System.out.println("Enter Name : ");
        name=in.next();
        user.setName(name);
        UserDao.update(user);

        System.out.println("\n\nDeleting data from database .");
        System.out.println("Enter id : ");
        id=in.nextInt();
        user=UserDao.get(id);
        UserDao.delete(user);


    }
}
