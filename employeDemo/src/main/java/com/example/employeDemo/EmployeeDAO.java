
    package com.example.employeDemo;

    import java.util.List;

    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.Transaction;

    public class EmployeeDAO {

        private SessionFactory sessionFactory;

        public EmployeeDAO() {
            sessionFactory = Utility.getSessionFactory();
        }

        private Session getSession() {
            return sessionFactory.openSession();
        }

        public void save(Employee e) {
            Session session = getSession();
            Transaction tx = session.beginTransaction();

            session.persist(e);

            tx.commit();
            session.close();
        }

        public List<Employee> findAll() {
            Session session = getSession();

            List<Employee> employees =
                    session.createQuery("FROM Employee", Employee.class).list();

            session.close();
            return employees;
        }

        public void update(Employee e) {
            Session session = getSession();
            Transaction tx = session.beginTransaction();

            session.merge(e);

            tx.commit();
            session.close();
        }

        public void delete(int id) {
            Session session = getSession();
            Transaction tx = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);

            if (employee != null) {
                session.remove(employee);
            }

            tx.commit();
            session.close();
        }

        public Employee findById(int id) {
            Session session = getSession();

            Employee employee = session.find(Employee.class, id);

            session.close();
            return employee;
        }
    }
   
