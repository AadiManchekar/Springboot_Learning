package com.aadi.ProductService.service.Implementations;

import static org.springframework.beans.BeanUtils.copyProperties;

import com.aadi.ProductService.entity.Product;
import com.aadi.ProductService.exception.ProductServiceCustomException;
import com.aadi.ProductService.model.ProductRequest;
import com.aadi.ProductService.model.ProductResponse;
import com.aadi.ProductService.repository.ProductRepository;
import com.aadi.ProductService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImplV1 implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public long addProduct(ProductRequest productRequest) {
    log.info("Adding product");
    Product product = Product
      .builder()
      .productName(productRequest.getName())
      .quantity(productRequest.getQuantity())
      .price(productRequest.getPrice())
      .build();

    productRepository.save(product);

    log.info("Product " + product.getProductId() + " Created");
    return product.getProductId();
  }

  @Override
  public ProductResponse getProductById(long id) {
    log.info("Get the product for productId: " + id);
    Product product = productRepository
      .findById(id)
      .orElseThrow(() ->
        new ProductServiceCustomException(
          "Product with given id not found " + id,
          "PRODUCT_NOT_FOUND"
        )
      );

    ProductResponse productResponse = new ProductResponse();
    // we can use the builder pattern or use BeanUtils
    // since in addProduct i used Builder pattern here i will use BeanUtils
    // make sure all the fields are same
    copyProperties(product, productResponse);
    return productResponse;
  }
}
