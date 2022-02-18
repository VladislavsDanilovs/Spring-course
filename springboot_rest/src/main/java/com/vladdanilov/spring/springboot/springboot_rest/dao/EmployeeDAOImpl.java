package com.vladdanilov.spring.springboot.springboot_rest.dao;

import com.vladdanilov.spring.springboot.springboot_rest.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements com.vladdanilov.spring.springboot.springboot_rest.dao.EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> getAllEmployees() {
        //entityManager is wrap of Session, so if we want to get session from it, we should use unwrap  (JPA)
//        Session session = entityManager.unwrap(Session.class);
//
//        //recommendation in spring documentation to separate this statement in 2 parts
//        Query<Employee> query = session.createQuery("from Employee"
//                , Employee.class);
//        List<Employee> AllEmployees = query.getResultList();

        //JPA solution(which is best practice, because we easily can change hibernate realization to another):
        Query query = entityManager.createQuery("from Employee"
                );
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//
//        //if employee.Id == 0 than that employee will be inserted, else update for employee
//        session.saveOrUpdate(employee);

        //JPA solution (merge = saveOrUpdate):
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {

//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        //JPA solution:
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        Query<Employee> query = session.createQuery("DELETE FROM Employee WHERE id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        //JPA solution:
        Query query = entityManager.createQuery("DELETE FROM Employee WHERE id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}