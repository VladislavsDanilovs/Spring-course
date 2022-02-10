package com.vladdanilov.spring.mvc_hibernate_aop.dao;


import com.vladdanilov.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

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
    @Transactional
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
}
