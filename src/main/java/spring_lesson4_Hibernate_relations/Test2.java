package spring_lesson4_Hibernate_relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson4_Hibernate_relations.entity.Detail;
import spring_lesson4_Hibernate_relations.entity.Employee;

//Bi-directional association
public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {

//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Viktor", "Chkar", "Sales", 250);
//            Detail detail = new Detail("Kiev", "1242131312", "viktorchkar@gmail.com");
//
//            employee.setEmpDetails(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction(); //opening transaction
//
//            session.save(employee);
//
//
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");


//            session = factory.getCurrentSession();
//
//            session.beginTransaction(); //opening transaction
//            Detail detail = session.get(Detail.class, 2);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");

            session = factory.getCurrentSession();

            session.beginTransaction(); //opening transaction
            Detail detail = session.get(Detail.class, 2);
            detail.getEmployee().setEmpDetails(null);
            session.delete(detail);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
            System.out.println("Successfully added to database!");


        } finally {
            session.close();
            factory.close();
        }
    }
}
