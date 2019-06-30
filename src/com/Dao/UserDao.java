package com.Dao;

import com.Factory.MyFactory;
import com.modal.configuration.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public static User get(int id) {
        Session session= MyFactory.getSession();
        User user=(User) session.get(User.class, id);
        session.close();
        return user!=null ? user : null;
    }

    public static void save(User user) {
        Session session= MyFactory.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public static void update(User user) {
        Session session= MyFactory.getSession();
        Transaction transaction=session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }

    public static void delete(User user) {
        Session session= MyFactory.getSession();
        Transaction transaction=session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
