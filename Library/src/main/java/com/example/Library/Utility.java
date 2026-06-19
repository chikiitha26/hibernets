package com.example.Library;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {

    private static SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Lib.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutdown() {
    	sessionFactory.close();
    }
}