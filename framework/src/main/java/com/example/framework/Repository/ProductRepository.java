package com.example.framework.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.framework.model.Product;




public interface ProductRepository extends JpaRepository<Product, Long> {
    // Métodos adicionais, se necessário
}