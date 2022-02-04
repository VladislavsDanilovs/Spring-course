package spring_lesson4_Hibernate_relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson4_Hibernate_relations.entity.Detail;
import spring_lesson4_Hibernate_relations.entity.Employee;

////Uni-directional association
public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Vlad", "Danilov", "IT", 800);
//            Detail detail = new Detail("Riga", "+37125451223", "vladislavs.danilovs@inbox.lv");
//
//            employee.setEmp_details(detail);
//            session.beginTransaction(); //opening transaction
//
//            session.save(employee);
//
//
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");

//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Zaur", "Tregulov", "IT", 1200);
//            Detail detail = new Detail("Baku", "1242131312", "zaurtregulov@gmail.com");
//
//            employee.setEmp_details(detail);
//            session.beginTransaction(); //opening transaction
//
//            session.save(employee);
//
//
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");

            session = factory.getCurrentSession();
            session.beginTransaction(); //opening transaction

            Employee myEmp = session.get(Employee.class, 2);

            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
            System.out.println("Successfully added to database!");
            System.out.println(myEmp);
            System.out.println(myEmp.getEmpDetails());
        } finally {
            session.close();
            factory.close();
        }
    }
}
