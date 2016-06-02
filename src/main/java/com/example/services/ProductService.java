package com.example.services;

import com.example.domain.Product;

import java.util.List;

/**
 * Created by jconnors on 6/1/16.
 */
public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);
}
