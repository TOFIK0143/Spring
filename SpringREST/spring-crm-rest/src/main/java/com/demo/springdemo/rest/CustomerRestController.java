package com.demo.springdemo.rest;

import com.demo.springdemo.entity.Customer;
import com.demo.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();

    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);

        if(customer == null)
        {
            throw new CustomerNotFoundException("Customer ID not found "+customerId);
        }

        return customer;

    }

    // add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer)
    {
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    // update customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer)
    {
        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    // add mapping for DELETE /customers/{customerId} - delete customer

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer tempCustomer = customerService.getCustomer(customerId);

        // throw exception if null

        if (tempCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Deleted customer id - " + customerId;
    }


}
