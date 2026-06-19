package com.example.StudentDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

    private SessionFactory sessionFactory;

    public StudentDAO() {
        sessionFactory = Utility.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public void save(Students s) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.persist(s);

        tx.commit();
        session.close();
    }

    public List<Students> findAll() {
        Session session = getSession();

        List<Students> students =
                session.createQuery("FROM Students", Students.class).list();

        session.close();
        return students;
    }

    public void update(Students s) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.merge(s);

        tx.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        Students student = session.find(Students.class, id);

        if (student != null) {
            session.remove(student);
        }

        tx.commit();
        session.close();
    }
    
}