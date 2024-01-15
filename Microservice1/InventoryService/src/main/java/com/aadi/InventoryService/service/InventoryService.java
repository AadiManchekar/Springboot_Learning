package com.aadi.InventoryService.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.aadi.InventoryService.entity.Inventory;
import com.aadi.InventoryService.repository.InventoryRepository;
import com.aadi.ProductService.model.ProductEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class InventoryService {

    private final InventoryRepository inventoryRepository;


    @KafkaListener(topics = "product-events")
    public void handleProductEvent(@Payload ProductEvent event,
                                   @Header(KafkaHeaders.CORRELATION_ID) String correlationId) {
        log.info("Updating inventory for product: {}", event.getProductId(), correlationId);

        // Fetch or create inventory record for the product
        Inventory inventory = inventoryRepository.findByProductId(event.getProductId());

        // Update inventory based on event type
        switch (event.getEventType()) {
            case CREATED:
                inventory.setQuantity(inventory.getQuantity() + event.getQuantity());
                break;
            case UPDATED:
                // Handle product updates as needed
                break;
            case DELETED:
                // Handle product deletion as needed
                break;
        }

        inventoryRepository.save(inventory);
    }
}