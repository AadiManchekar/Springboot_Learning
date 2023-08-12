package com.aadi.OrderService.controller;

import com.aadi.OrderService.model.OrderRequest;
import com.aadi.OrderService.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Log4j2
public class OrderController {

  @Autowired
  OrderService orderService;

  @PostMapping
  public ResponseEntity<Long> placeOrder(
    @RequestBody OrderRequest orderRequest
  ) {
    long orderId = orderService.placeOrder(orderRequest);
    log.info("Order Id: {}", orderId);
    return new ResponseEntity<Long>(orderId, HttpStatus.OK);
  }
}
