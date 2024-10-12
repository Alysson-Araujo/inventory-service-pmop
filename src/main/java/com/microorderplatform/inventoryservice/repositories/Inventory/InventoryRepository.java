package com.microorderplatform.inventoryservice.repositories.Inventory;

import com.microorderplatform.inventoryservice.models.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InventoryRepository extends JpaRepository<InventoryModel, UUID> {
    Optional<InventoryModel> findByProductId(UUID productId);

}
