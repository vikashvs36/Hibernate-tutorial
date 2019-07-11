package com.Test;

import com.Dao.UserDao;
import com.Factory.MyFactory;
import com.modal.one_to_one_Bidirectional.Address;
import com.modal.one_to_one_Bidirectional.User;
import org.hibernate.Session;

public class OnetoOneBidirectional {

    public static void main(String[] args) {
        User user=new User("Vikash", "Singh");
        Address address=new Address("noida", "Up");
        address.setUser(user);
        user.setAddress(address);

        UserDao.save(user);
        System.out.println("Saved User and Address Object using one to one unidirectional mapping.");


        System.out.println("\n\nAccessing of collection objects.");
        Session session= MyFactory.getSession();
        User getUser = (User) session.get(User.class, 1);
        System.out.println("\nWe can get address behalf of user : ");
        System.out.println(" User : " +getUser);
        System.out.println("Address : "+getUser.getAddress());

        Address getAddress = (Address) session.get(Address.class, 1);
        System.out.println("\nWe can get user as well behalf of address : ");
        System.out.println("Address : "+getAddress);
        System.out.println(" User : " +getAddress.getUser());
        session.close();


        System.out.println("\nDeleting User and let see address will delete or not?");
        session = MyFactory.getSession();
        User delelteUser=(User) session.get(User.class, 1);
        UserDao.delete(delelteUser);
        System.out.println("Address deleted as will");

    }
}
