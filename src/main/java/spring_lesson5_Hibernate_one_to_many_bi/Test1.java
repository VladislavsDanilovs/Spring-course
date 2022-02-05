package spring_lesson5_Hibernate_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson5_Hibernate_one_to_many_bi.entity.Department;
import spring_lesson5_Hibernate_one_to_many_bi.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            Department dep = new Department("IT", 1200, 500);
            Employee emp1 = new Employee("Vlad", "Danilov", 800);
            Employee emp2 = new Employee("KZaur", "Tregulov", 1200);

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.beginTransaction(); //opening transaction
            session.save(dep);

            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
            System.out.println("Successfully added to database!");
//              --------------------------------------------------------------------
//            session = factory.getCurrentSession();
//            session.beginTransaction(); //opening transaction
//            Department myDep = session.get(Department.class, 1);
//            System.out.println(myDep);
//            System.out.println(myDep.getEmps());
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");

            //--------------------------------------------------------------------------------
//            session = factory.getCurrentSession();
//            session.beginTransaction(); //opening transaction
//            Employee myEmp = session.get(Employee.class, 1);
//            System.out.println(myEmp);
//            System.out.println(myEmp.getDepartment());
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");


//            session = factory.getCurrentSession();
//            session.beginTransaction(); //opening transaction
//            Employee myEmp = session.get(Employee.class, 2);
//            session.delete(myEmp);
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");


        } finally {
            session.close();
            factory.close();
        }
    }
}
