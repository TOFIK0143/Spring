package com.demo.SpringBoot.CRUDDemo.Service;

import com.demo.SpringBoot.CRUDDemo.DAO.EmployeeDAO;
import com.demo.SpringBoot.CRUDDemo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    public String Delete(int Id) {
        return employeeDAO.Delete(Id);
    }

}
