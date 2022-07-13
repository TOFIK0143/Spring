package com.example.demo.service;

import com.example.demo.model.CustomUserDetail;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("user is not recognized"));
        return user.map(CustomUserDetail::new).get();

        //new code
        //fetching user from database
//        User user=userRepository.getUserByEmail(email);
//        if(user==null)
//        {
//            throw new UsernameNotFoundException("User not found!");
//        }
//
//        CustomUserDetail customUserDetail = new CustomUserDetail(user);
//        return customUserDetail;
    }
}
