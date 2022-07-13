package com.demo.SpringBoot.CURDDemo.DAO;

import com.demo.SpringBoot.CURDDemo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    @Autowired
    private EntityManager  entityManager;


    public List<Employee> findAll() {

       Query employeeQuery = entityManager.createQuery("from Employee");

       List<Employee> employeeLIst = employeeQuery.getResultList();

        return employeeLIst;
    }

    public Employee findById(int theId) {
       Employee employee = entityManager.find(Employee.class,theId);
        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + theId);
        }
        return employee;
    }


    public Employee save(Employee employee) {
        try {
            entityManager.merge(employee);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return employee;
    }


    public String Delete(int Id) {

        try {
            Employee employee = entityManager.find(Employee.class,Id);
            entityManager.remove(employee);

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
