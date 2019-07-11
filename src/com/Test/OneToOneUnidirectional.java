package com.Test;

import com.Dao.UserDao;
import com.Factory.MyFactory;
import com.modal.one_to_one_Unidirectional.Address;
import com.modal.one_to_one_Unidirectional.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOneUnidirectional {

    public static void main(String[] args) {
        User user=new User("Vikash", "Singh");
        Address address=new Address("noida", "Up");
        user.setAddress(address);
        UserDao.save(user);
        System.out.println("Saved User and Address Object using one to one unidirectional mapping.");


        System.out.println("\nAccessing of collection objects.");
        Session session= MyFactory.getSession();
        User getUser = (User) session.get(User.class, 1);
        System.out.println(" User : " +getUser);
        Address getAddress = (Address) session.get(Address.class, getUser.getAddress().getAddressId());
        System.out.println("Address : "+getAddress);
        session.close();
    }
}

/*
Note : The main problem of the one to one unidirectionnal is that, we can fetch address behalf of user bt We can't access address.

        So, to overcome this issue we can use Bidirectional.
*/
