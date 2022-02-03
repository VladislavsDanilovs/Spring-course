package spring_lesson3_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson3_Hibernate.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("David", "Li", "IT", 600);

            session.beginTransaction(); //opening transaction
            session.save(emp); //Hibernate writing Insert query
            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
            System.out.println("Successfully added to database!");
            System.out.println(emp);
        }
        finally {
            factory.close();
        }
    }
}
