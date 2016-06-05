package com.example.controllers;

import com.example.domain.Customer;
import com.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jconnors on 6/2/16.
 */
@RequestMapping("/customer")
@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = {"/list", "/"})
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.listAll());
        return "customer/list"; // maps to thymeleaf template named list.html in customer directory
    }

    @RequestMapping("/show/{id}")
    public String showCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer/show"; // maps to thymeleaf template named show.html in customer directory
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerform"; // maps to thymeleaf template named customerform.html in customer directory
    }

    @RequestMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerform"; // maps to thymeleaf template named customerform.html in customer directory
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Customer customer) {
        Customer newCustomer = customerService.saveOrUpdate(customer);
        return "redirect:/customer/show/" + newCustomer.getId();
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
