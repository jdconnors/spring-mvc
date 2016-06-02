package com.example.services;

import com.example.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by jconnors on 6/2/16.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null) {
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);

            return customer;
        } else {
            throw new RuntimeException("Customer can't be null");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private Integer getNextKey() {
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomers() {
        customers = new HashMap<>();
        IntStream.range(1, 6)
                .boxed()
                .forEach(i -> {
                    Customer customer = new Customer();
                    customer.setId(i);
                    customer.setFirstName("FName" + i);
                    customer.setLastName("LName" + i);
                    customer.setEmail("fnamelname" + i);
                    customer.setPhoneNumber("206555100" + i);
                    customer.setAddress1("address1-" + i);
                    customer.setAddress2("address2-" + i);
                    customer.setCity("Seattle");
                    customer.setState("WA");
                    customer.setZipCode("98121");
                    customers.put(i, customer);
                });
    }
}
