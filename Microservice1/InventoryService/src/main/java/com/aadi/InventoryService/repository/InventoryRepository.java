package com.aadi.InventoryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadi.InventoryService.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByProductId(Long productId);
}