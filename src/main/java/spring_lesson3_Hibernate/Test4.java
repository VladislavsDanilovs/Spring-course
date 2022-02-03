package spring_lesson3_Hibernate;
//UPDATE
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson3_Hibernate.entity.Employee;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //opening transaction

//            Employee emp = session.get(Employee.class, 2);
//            emp.setSalary(1500);

            session.createQuery("update Employee SET salary = 1000 WHERE name = 'David'").executeUpdate();

            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}
