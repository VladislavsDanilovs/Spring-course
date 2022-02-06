package spring_lesson5_Hibernate_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring_lesson5_Hibernate_one_to_many_bi.entity.Department;
import spring_lesson5_Hibernate_one_to_many_bi.entity.Employee;

import java.util.List;

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
//            Department dep = new Department("Sales", 1500, 800);
//            Employee emp1 = new Employee("Taras", "Pavlov", 800);
//            Employee emp2 = new Employee("Aizek", "Clark", 1500);
//            Employee emp3 = new Employee("Kaine", "Kent", 805);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction(); //opening transaction
//            session.save(dep);
//
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");
//              --------------------------------------------------------------------
            session = factory.getCurrentSession();
            session.beginTransaction(); //opening transaction
            System.out.println("Get department");
            Department myDep = session.get(Department.class, 10);
            System.out.println("Show department");
            System.out.println(myDep);

            System.out.println("Loading employees");
            myDep.getEmps().get(0); //initializing lazy loading


            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert

            System.out.println("Show department employees");
            System.out.println(myDep.getEmps());

            System.out.println("Done!");

            //--------------------------------------------------------------------------------
//            session = factory.getCurrentSession();
//            session.beginTransaction(); //opening transaction
//            Employee myEmp = session.get(Employee.class, 1);
//            System.out.println(myEmp);
//            System.out.println(myEmp.getDepartment());
//            session.getTransaction().commit();  //closing transaction or using rollback() if we want to undo insert
//            System.out.println("Successfully added to database!");
            //--------------------------------------------------------------------------------


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
