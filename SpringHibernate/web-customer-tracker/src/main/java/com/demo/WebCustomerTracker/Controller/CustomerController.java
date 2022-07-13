package com.demo.WebCustomerTracker.Controller;

import com.demo.WebCustomerTracker.DAO.CustomerDAO;
import com.demo.WebCustomerTracker.Entity.Customer;
import com.demo.WebCustomerTracker.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

// need to inject service in this controller

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String add(Model model)
    {
        //get the customers from service
        List<Customer> theCustomers = customerService.getCustomer();

        // add  those customers to spring mvc model
        model.addAttribute("customers",theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        // create model attribute to bind form data

        Customer theCustomer = new Customer();

        model.addAttribute("customer",theCustomer);


          return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
    {
        // save the customer
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int Id, Model theModel )
    {
         // get the customer from service
         Customer theCustomer = customerService.getCustomer(Id);

        //set the customer as model to pre-populate the form
         theModel.addAttribute("customer",theCustomer);

        //send over to form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id)
    {

        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }
}
