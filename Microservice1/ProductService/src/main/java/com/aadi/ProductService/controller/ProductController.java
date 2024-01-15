package com.aadi.ProductService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.aadi.ProductService.entity.Product;
import com.aadi.ProductService.model.ProductEvent;
import com.aadi.ProductService.model.ProductEventType;
import com.aadi.ProductService.model.ProductRequest;
import com.aadi.ProductService.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    
    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest,
                                              @RequestHeader("X-Correlation-ID") String correlationId) {
        Product product = productService.addProduct(productRequest);

        // Send message to inventory service with correlation ID
        ProductEvent event = new ProductEvent(product.getId(), ProductEventType.CREATED, product.getQuantity());
        kafkaTemplate.send("product-events", correlationId, event);

        return ResponseEntity.ok(product);
    }
}
