package com.example.productservice.service;

import com.example.api.core.product.Product;
import com.example.api.core.product.ProductService;
import com.example.api.exceptions.InvalidInputException;
import com.example.api.exceptions.NotFoundException;
import com.example.util.http.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductServiceImpl implements ProductService {

  private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

  private final ServiceUtil serviceUtil;

  @Override
  public Product getProduct(int productId) {
    LOG.debug("/product return the found product for productId={}", productId);

    if (productId < 1) {
      throw new InvalidInputException("Invalid productId: " + productId);
    }

    if (productId == 13) {
      throw new NotFoundException("No product found for productId: " + productId);
    }
    
    return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
  }
}
