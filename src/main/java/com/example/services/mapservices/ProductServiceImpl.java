package com.example.services.mapservices;

import com.example.domain.DomainObject;
import com.example.domain.Product;
import com.example.services.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by jconnors on 6/1/16.
 */
@Service
@Profile({"default", "map"})
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) { return (Product) super.saveOrUpdate(domainObject); }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
