package com.Factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyFactory {

    private static SessionFactory factory;

    static {
        try {
            Configuration cfg = new Configuration().configure();
            factory = cfg.buildSessionFactory();
        }catch (Exception e) {
            System.out.println("Exception : "+e);
        }
    }

    public static Session getSession() {
        return factory.openSession();
    }

}
