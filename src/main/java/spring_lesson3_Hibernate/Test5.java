package spring_lesson3_Hibernate;
//DELETE
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson3_Hibernate.entity.Employee;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //opening transaction

            //delete 1 person
//            Employee emp = session.get(Employee.class, 6);
//            session.delete(emp);

            session.createQuery("DELETE Employee WHERE name = 'David'").executeUpdate();

            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}
