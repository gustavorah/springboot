package com.example.framework.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.framework.model.Category;
import com.example.framework.model.Product;
import com.example.framework.service.CategoryService;
import com.example.framework.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "view/add-product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product Product) {
        productService.save(Product);
        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public String showListProductForm(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "view/list-product";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.getproductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "view/edit-product";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("prdoduct") Product product) {
        productService.update(product);
        return "redirect:/products/list";
    }
}


