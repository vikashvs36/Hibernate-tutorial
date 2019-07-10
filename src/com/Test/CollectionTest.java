package com.Test;

import com.Dao.UserDao;
import com.modal.collection.Address;
import com.modal.collection.User;

public class CollectionTest {

    public static void main(String[] args) {

        User user=new User("Vikash", "Vikash");

//        Set<Address> addressSet=new HashSet<>();
        Address address1=new Address("noida", "Up");
        Address address2=new Address("delhi", "new delhi");

        user.getAddressSet().add(address1);
        user.getAddressSet().add(address2);

        UserDao.save(user);
        System.out.println("Achived of collection objects.");

    }
}
