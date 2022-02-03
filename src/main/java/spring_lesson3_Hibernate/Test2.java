package spring_lesson3_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson3_Hibernate.entity.Employee;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Viktor", "K", "Sales", 805);

            session.beginTransaction(); //opening transaction
            session.save(emp); //Hibernate writing Insert query
            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert

            //Getting employee from database
            int myId = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);

            System.out.println("Successfully added to database!");

        }
        finally {
            factory.close();
        }
    }
}
