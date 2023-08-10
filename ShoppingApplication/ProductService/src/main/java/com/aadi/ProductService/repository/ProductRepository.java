package com.aadi.ProductService.repository;

import com.aadi.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// no need for @Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
