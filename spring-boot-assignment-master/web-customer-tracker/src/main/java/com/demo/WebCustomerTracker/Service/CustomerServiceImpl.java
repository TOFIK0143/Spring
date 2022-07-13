package com.demo.WebCustomerTracker.Service;

import com.demo.WebCustomerTracker.DAO.CustomerDAO;
import com.demo.WebCustomerTracker.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
   private CustomerDAO customerDAO;


    @Transactional
    public List<Customer> getCustomer() {

        return customerDAO.getCustomer();
    }


    @Transactional
    public void saveCustomer(Customer theCustomer) {

        customerDAO.saveCustomer(theCustomer);
    }

    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Transactional
    public void deleteCustomer(int id) {

        customerDAO.deleteCustomer(id);
    }
}
