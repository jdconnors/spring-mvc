package com.example.services;

import com.example.config.JpaIntegrationConfig;
import com.example.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jconnors on 6/10/16.
 *
 * NOTE: This is actually an integration test, not a unit test.
 * The instructor chose to name it with the "Test" suffix rather than the "IT" suffix so
 * that he didn't have to configure maven to look for the "IT" suffix.  But this can be done.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles({"jpadao"})
public class ProductServiceJpaDaoImplTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testListMethod() throws Exception {

        List<Product> products = (List<Product>) productService.listAll();

        assert products.size() == 5;
    }
}
