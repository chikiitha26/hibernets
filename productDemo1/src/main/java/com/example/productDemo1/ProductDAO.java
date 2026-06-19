package com.example.productDemo1;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class ProductDAO {

    private SessionFactory sessionFactory;

    public ProductDAO() {
        sessionFactory = Utility.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public void save(Product p) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.persist(p);

        tx.commit();
        session.close();
    }

    public List<Product> findAll() {
        Session session = getSession();

        List<Product> products =
                session.createQuery("FROM Product", Product.class).list();

        session.close();
        return products;
    }

    public void update(Product p) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        session.merge(p);

        tx.commit();
        session.close();
    }

//    public void delete(int id) {
//        Session session = getSession();
//        Transaction tx = session.beginTransaction();
//
//        Product product = session.get(Product.class, id);
//
//        if (product != null) {
//            session.remove(product);
//        }
//
//        tx.commit();
//        session.close();
//    }
}