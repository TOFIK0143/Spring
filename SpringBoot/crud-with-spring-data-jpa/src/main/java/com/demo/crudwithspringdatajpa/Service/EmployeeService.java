package com.demo.crudwithspringdatajpa.Service;


import com.demo.crudwithspringdatajpa.Entity.Employee;

import java.util.List;

public interface EmployeeService {


    public List<Employee> findAll();

    public Employee findById(int theId);

    public Employee save(Employee employee);

    public void deleteById(int Id);
}
