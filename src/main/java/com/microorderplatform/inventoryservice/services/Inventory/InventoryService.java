package com.microorderplatform.inventoryservice.services.Inventory;


import com.microorderplatform.inventoryservice.models.InventoryModel;
import com.microorderplatform.inventoryservice.models.ProductModel;
import com.microorderplatform.inventoryservice.repositories.Inventory.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public InventoryModel saveInventory(InventoryModel inventoryModel) {
        return inventoryRepository.save(inventoryModel);
    }

    public boolean isProductInInventory(UUID productId) {
        Optional<InventoryModel> inventory = inventoryRepository.findByProductId(productId);
        return inventory.isPresent();
    }
    public InventoryModel findInventoryByProductId(UUID productId) {
        return inventoryRepository.findByProductId(productId).orElse(null);
    }

    public Iterable<InventoryModel> findAllInventories() {
        return inventoryRepository.findAll();
    }
}
