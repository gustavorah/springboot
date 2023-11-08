package com.example.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.framework.Repository.ProductRepository;
import com.example.framework.model.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getproductById(Long id) {
        return productRepository.findById(id);
    }

    public void update(Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(updatedProduct.getId());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setId(updatedProduct.getId());
            product.setCategory(updatedProduct.getCategory());
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            // Update other fields as needed
            productRepository.save(product);
        } else {
            System.err.println();
        }
    }
}
