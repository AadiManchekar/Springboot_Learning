package com.aadi.OrderService.external.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PRODUCT-SERVICE/product")
public interface ProductService {
    
}
