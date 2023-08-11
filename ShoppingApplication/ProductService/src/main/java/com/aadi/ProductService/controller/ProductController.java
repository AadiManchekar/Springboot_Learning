package com.aadi.ProductService.controller;

import com.aadi.ProductService.model.ProductRequest;
import com.aadi.ProductService.model.ProductResponse;
import com.aadi.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  // Add products
  // this will take request body as object so we need a class
  // that can handle particular response body (json format into a class)
  // hence creating a Class in model (ProductRequest)
  @PostMapping
  private ResponseEntity<Long> addProduct(
    @RequestBody ProductRequest productRequest
  ) {
    long productId = productService.addProduct(productRequest);
    return new ResponseEntity<>(productId, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) {
    ProductResponse productResponse = productService.getProductById(id);
    return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
  }
}
