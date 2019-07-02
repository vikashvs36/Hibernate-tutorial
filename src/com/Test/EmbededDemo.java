package com.Test;

import com.Dao.UserDao;
import com.Factory.MyFactory;
import com.modal.Embeded.Address;
import com.modal.Embeded.User;
import org.hibernate.Session;

public class EmbededDemo {

    public static void main(String[] args) {

        Address homeAddress=new Address("Chapra", "Bihar", "India", 841419);
        Address officeAddress=new Address("noida", "Up", "India", 110046);
        User user=new User("Vikash","Singh", homeAddress, officeAddress );
        UserDao.save(user);
        System.out.println("User and address has been saved.");

        Session session= MyFactory.getSession();
        User user1=session.get(User.class, 1);
        System.out.println(user1);

    }
}
