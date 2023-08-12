package com.aadi.OrderService.service.Implementation;

import com.aadi.OrderService.entity.Order;
import com.aadi.OrderService.model.OrderRequest;
import com.aadi.OrderService.repository.OrderRepository;
import com.aadi.OrderService.service.OrderService;
import java.time.Instant;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OrderServiceImplementation implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public long placeOrder(OrderRequest orderRequest) {
    // Order Entity -> Save the data with Status Order Created
    // Product Service -> Block Products (Reduce the quantity)
    // Payment Service -> Payments -> Success -> COMPLETE, ELSE CANCELED

    log.info("Placing Order Request: {}", orderRequest);

    Order order = Order
      .builder()
      .amount(orderRequest.getTotalAmount())
      .orderStatus("CREATED")
      .productId(orderRequest.getProductId())
      .orderDate(Instant.now())
      .quantity(orderRequest.getQuantity())
      .build();

    order = orderRepository.save(order);

    log.info("Order Placed Successfully with Order Id: {}", order.getId());
    return order.getId();
  }
}
