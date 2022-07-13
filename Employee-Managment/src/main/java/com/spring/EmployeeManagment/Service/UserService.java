package com.spring.EmployeeManagment.Service;

import com.spring.EmployeeManagment.DTO.UserRegistrationDto;
import com.spring.EmployeeManagment.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);


}
