package com.aadi.ProductService.service;

import com.aadi.ProductService.model.ProductRequest;
import com.aadi.ProductService.model.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);

    void reduceQuantity(long productId, long quantity);
    
}
