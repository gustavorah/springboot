package com.example.framework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.framework.service.CategoryService;
import com.example.framework.service.ProductService;

@SpringBootApplication
public class FrameworkApplication implements CommandLineRunner {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(FrameworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
