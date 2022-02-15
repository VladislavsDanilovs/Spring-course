package com.vladdanilov.spring.rest.dao;


import com.vladdanilov.spring.rest.entity.Employee;
import com.vladdanilov.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class EmployeeDAOImpl implements com.vladdanilov.spring.rest.dao.EmployeeDAO {

//    @Autowired //field DI
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @Autowired //DI using setter
//    public void setSessionFactory(SessionFactory sessionFactory){
//        this.sessionFactory = sessionFactory;
//    }

    @Override
//    @Transactional //This annotation should be in service getAllEmployee method
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

//        List<Employee> allEmployees = session.createQuery("from Employee"
//                        , Employee.class).getResultList();

        //recommendation in spring documentation to separate this statement in 2 parts
        Query<Employee> query = session.createQuery("from Employee"
                , Employee.class);
        List<Employee> AllEmployees = query.getResultList();

        return AllEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        //if employee.Id == 0 than that employee will be inserted, else update for employee
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("DELETE FROM Employee WHERE id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
