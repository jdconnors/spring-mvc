package com.example.services;

import com.example.domain.Customer;
import com.example.domain.DomainObject;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by jconnors on 6/2/16.
 */
@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() { return super.listAll(); }

    @Override
    public Customer getById(Integer id) { return (Customer) super.getById(id); }

    @Override
    public Customer saveOrUpdate(Customer domainObject) { return (Customer) super.saveOrUpdate(domainObject); }

    @Override
    public void delete(Integer id) { super.delete(id); }

    protected void loadDomainObjects() {
        domainMap = new HashMap<>();
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
                    domainMap.put(i, customer);
                });
    }
}
