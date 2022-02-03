package spring_lesson3_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson3_Hibernate.entity.Employee;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //opening transaction

            //HQL, in this language we are working with classes, fields and etc., that why we're writing class name instead of table name
            List<Employee> emps = session.createQuery("from Employee WHERE name = 'David' AND salary >=600")
                            .getResultList();

            for(Employee e : emps){
                System.out.println(e);
            }

            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert

//            System.out.println("Successfully added to database!");

        }
        finally {
            factory.close();
        }
    }
}
