package com.demo.WebCustomerTracker.DAO;

import com.demo.WebCustomerTracker.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
   private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomer() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;



    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Customer theCustomer = currentSession.get(Customer.class,id);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete the customer
        Customer theCustomer = currentSession.get(Customer.class,id);
        currentSession.delete(theCustomer);

    }
}
