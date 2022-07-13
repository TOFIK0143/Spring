package com.demo.SpringBoot.CURDDemo.Service;

import com.demo.SpringBoot.CURDDemo.Entity.Employee;

import java.util.List;

public interface EmployeeService {


    public List<Employee> findAll();

    public Employee findById(int theId);

    public Employee save(Employee employee);

    public String Delete(int Id);
}
