package com.aadi.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadi.ProductService.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
