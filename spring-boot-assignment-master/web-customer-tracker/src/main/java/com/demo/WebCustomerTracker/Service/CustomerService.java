package com.demo.WebCustomerTracker.Service;

import com.demo.WebCustomerTracker.Entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomer();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
