package com.aadi.ApiGateway.controller;

import java.util.UUID;

import org.apache.kafka.common.requests.ProduceRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aadi.ApiGateway.DTO.Product;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiGatewayController {
    
    private final RestTemplate restTemplate;

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        String correlationId = UUID.randomUUID().toString();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Correlation-ID", correlationId);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Product> response = restTemplate.exchange(
                "http://product-service/products/{id}",
                HttpMethod.GET,
                requestEntity,
                Product.class,
                id
        );

        return response;
    }


        @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody ProduceRequest productRequest,
                                              @RequestHeader("X-Correlation-ID") String correlationId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Correlation-ID", correlationId);
        HttpEntity<ProduceRequest> requestEntity = new HttpEntity<>(productRequest, headers);

        ResponseEntity<Product> response = restTemplate.exchange(
                "http://product-service/products", // Placeholder for service discovery
                HttpMethod.POST,
                requestEntity,
                Product.class
        );

        return response;
    }
}