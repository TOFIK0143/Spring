package com.demo.SpringBoot.CURDDemo.DAO;

import com.demo.SpringBoot.CURDDemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int theId);


    public Employee save(Employee employee);

    public String Delete(int Id);
}
