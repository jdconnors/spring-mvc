package com.example.controllers;

import com.example.domain.Product;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jconnors on 6/1/16.
 */
@RequestMapping("/product")
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAll());
        return "/product/list"; // maps to thymeleaf template named list.html in the product directory
    }

    @RequestMapping("/show/{id}")
    public String getProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "/product/show"; // maps to thymeleaf template named show.html in product directory
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "/product/productform"; // maps to thymeleaf template named productform.html in product directory
    }

    @RequestMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/product/productform"; // maps to thymeleaf template named productform.html in product directory
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product newProduct = productService.saveOrUpdate(product);
        return "redirect:/product/show/" + newProduct.getId();
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/product/list";
    }
}
