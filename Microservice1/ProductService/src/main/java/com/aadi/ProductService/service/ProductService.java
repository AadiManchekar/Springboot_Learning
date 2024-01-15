package com.aadi.ProductService.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.aadi.ProductService.entity.Product;
import com.aadi.ProductService.model.ProductEvent;
import com.aadi.ProductService.model.ProductEventType;
import com.aadi.ProductService.model.ProductRequest;
import com.aadi.ProductService.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public Product addProduct(ProductRequest productRequest) {

        Product product= Product.builder().name(productRequest.getName()).price(productRequest.getPrice()).quantity(productRequest.getQuantity()).build();
        product = productRepository.save(product);

        // Send product event to Kafka
        ProductEvent event = new ProductEvent(product.getId(), ProductEventType.CREATED, product.getQuantity());
        kafkaTemplate.send("product-events", event);

        return product;
    }

    // ... other product-related operations
}