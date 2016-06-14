package com.example.services;

import com.example.config.JpaIntegrationConfig;
import com.example.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    /* This test was provided by the instructor in the tutorial, but it is not
    a good test assumption.  Tests are not necessarily run in order.
    If one of the other tests runs first and changes the number of records
    then this test will fail - because it is assuming that SpringJPABootstrap.loadProducts() has
    just run and nothing else.
     */
    @Test
    public void testListMethod() throws Exception {

        List<Product> products = (List<Product>) productService.listAll();

        System.out.println("products.size() = " + products.size());
        assert products.size() == 5;
    }

    @Test
    public void testGetByIdMethod() throws Exception {

        Product product = productService.getById(2);

        assert product.getId() == 2;
        assert 0 == product.getDescription().compareTo("Product 2");
        assert product.getPrice().doubleValue() == 14.99;
        assert 0 == product.getImageUrl().compareTo("http://example.com/product2");
    }

    @Test
    public void testSaveOrUpdateMethodForSave() throws Exception {

        List<Product> productsBefore = (List<Product>) productService.listAll();

        String description = "New Test Product";
        BigDecimal price = new BigDecimal("199.99");
        String imageUrl = "http://new.test.url";

        Product productNew = new Product();
        productNew.setDescription(description);
        productNew.setPrice(price);
        productNew.setImageUrl(imageUrl);
        Product savedProduct = productService.saveOrUpdate(productNew);

        List<Product> productsAfter = (List<Product>) productService.listAll();
        assert productsAfter.size() == productsBefore.size() + 1;

        Optional optionalProduct = productsBefore
                .stream()
                .collect(Collectors.maxBy(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getId() - o2.getId();
                    }
                }));
        Integer resultInteger = optionalProduct.isPresent() ? ((Product) optionalProduct.get()).getId() : 0;
        assert savedProduct.getId() > resultInteger;

        Product retrievedProduct = productService.getById(savedProduct.getId());
        assert 0 == retrievedProduct.getDescription().compareTo(description);
        assert retrievedProduct.getPrice() == price;
        assert 0 == retrievedProduct.getImageUrl().compareTo(imageUrl);
    }

    @Test
    public void testSaveOrUpdateMethodForUpdate() throws Exception {
        //$TODO
    }

    public void testDeleteMethod() throws Exception {
        //$TODO
    }
}
