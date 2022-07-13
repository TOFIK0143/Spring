package com.demo.SpringBoot.CRUDDemo.DAO;

import com.demo.SpringBoot.CRUDDemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int theId);


    public Employee save(Employee employee);

    public String Delete(int Id);
}