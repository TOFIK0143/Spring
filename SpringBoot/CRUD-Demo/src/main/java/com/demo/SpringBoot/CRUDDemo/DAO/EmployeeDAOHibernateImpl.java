package com.demo.SpringBoot.CRUDDemo.DAO;

import com.demo.SpringBoot.CRUDDemo.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    @Autowired
    private EntityManager manager;



    @Transactional
    public List<Employee> findAll() {

        // get the current hibernate session
        Session session = manager.unwrap(Session.class);
        //create query
        Query<Employee> employeeQuery = session.createQuery("from Employee",Employee.class);
        //execute query
        List<Employee> employeeLIst = employeeQuery.getResultList();
        //return the result
        return employeeLIst;
    }

    @Transactional
    public Employee findById(int theId) {

        Session session = manager.unwrap(Session.class);

        Employee employee = session.get(Employee.class,theId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + theId);
        }

        return employee;
    }

    @Transactional
    public Employee save(Employee employee) {
        Session session = manager.unwrap(Session.class);

        try {
            session.saveOrUpdate(employee);

        }catch (Exception e)
        {
            e.printStackTrace();

        }

        return employee;
    }

    @Transactional
    public String Delete(int Id) {
        Session session = manager.unwrap(Session.class);

        try {
            Employee employee = session.get(Employee.class,Id);
            session.delete(employee);

        }catch (Exception e)
        {
            e.printStackTrace();
            return "Failed!! Exception Occurred";        }

        return "Success!! Deleted Employee ID: "+Id ;
    }

//    @Override
//    public void deleteById(int theId) {
//
//        // get the current hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // delete object with primary key
//        Query theQuery =
//                currentSession.createQuery(
//                        "delete from Employee where id=:employeeId");
//        theQuery.setParameter("employeeId", theId);
//
//        theQuery.executeUpdate();
//    }
}
