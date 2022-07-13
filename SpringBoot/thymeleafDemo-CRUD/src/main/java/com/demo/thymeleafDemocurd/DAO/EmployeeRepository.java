package com.demo.thymeleafDemocurd.DAO;


import com.demo.thymeleafDemocurd.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();


}
