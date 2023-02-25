package com.luv2code.Dao;

import com.luv2code.Entity.Customer;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerDaoImpl implements CustomerDAO{

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    // It does not work as expected
    @Override
    public List<Customer> getCustomers() {

        return null;
    }

}
