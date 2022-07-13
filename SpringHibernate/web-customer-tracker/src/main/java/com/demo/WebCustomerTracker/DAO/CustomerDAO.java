package com.demo.WebCustomerTracker.DAO;

import com.demo.WebCustomerTracker.Entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomer();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
