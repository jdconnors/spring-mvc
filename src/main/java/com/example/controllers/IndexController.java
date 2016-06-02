package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jconnors on 6/1/16.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index"; // maps to thymeleaf template named index.html
    }
}
