package com.demo.SpringBoot.CRUDDemo.REST;


import com.demo.SpringBoot.CRUDDemo.DAO.EmployeeDAO;
import com.demo.SpringBoot.CRUDDemo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeRESTController {

    @Autowired
    private EmployeeDAO employeeDAO;


    @GetMapping("/employee")
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }

    @GetMapping("/employee/{ID}")
    public Employee findById(@PathVariable int ID)
    {
        return employeeDAO.findById(ID);
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee) {

        employee.setId(0);
        return employeeDAO.save(employee);
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        return employeeDAO.save(theEmployee);
    }

    @DeleteMapping("/employee/{Id}")
    public String Delete(@PathVariable int Id) {
        return employeeDAO.Delete(Id);
    }
}
