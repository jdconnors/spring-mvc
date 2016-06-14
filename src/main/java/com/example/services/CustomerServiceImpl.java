package com.example.services;

import com.example.domain.Customer;
import com.example.domain.DomainObject;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by jconnors on 6/2/16.
 */
@Service
@Profile({"default", "map"})
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() { return super.listAll(); }

    @Override
    public Customer getById(Integer id) { return (Customer) super.getById(id); }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) { super.delete(id); }
}
