package com.example.services;

import com.example.domain.Customer;

import java.util.List;

/**
 * Created by jconnors on 6/2/16.
 */
public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
