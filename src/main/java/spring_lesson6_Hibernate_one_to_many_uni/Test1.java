package spring_lesson6_Hibernate_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson6_Hibernate_one_to_many_uni.entity.Department;
import spring_lesson6_Hibernate_one_to_many_uni.entity.Employee;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("HR", 500, 400);
//            Employee emp1 = new Employee("Oleg", "Lux", 450);
//            Employee emp2 = new Employee("Ivan", "Br", 500);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.beginTransaction(); //opening transaction
//            session.save(dep);
//
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");
//              --------------------------------------------------------------------
//            session = factory.getCurrentSession();
//            session.beginTransaction(); //opening transaction
//            Department myDep = session.get(Department.class, 9);
//            System.out.println(myDep);
//            System.out.println(myDep.getEmps());
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");

            //--------------------------------------------------------------------------------
//            session = factory.getCurrentSession();
//            session.beginTransaction(); //opening transaction
//            Employee myEmp = session.get(Employee.class, 3);
//            System.out.println(myEmp);
//
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");


            session = factory.getCurrentSession();
            session.beginTransaction(); //opening transaction
            Department myEmp = session.get(Department.class, 9);
            session.delete(myEmp);
            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
            System.out.println("Successfully added to database!");


        } finally {
            session.close();
            factory.close();
        }
    }
}
