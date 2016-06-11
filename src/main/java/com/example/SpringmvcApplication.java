package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringmvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringmvcApplication.class, args);

//		System.out.println("Beans ******");
//		System.out.println("bean count = " + ctx.getBeanDefinitionCount());
//		for (String name : ctx.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}
}
