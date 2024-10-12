package com.microorderplatform.inventoryservice.DTOs;

import com.microorderplatform.inventoryservice.models.ProductModel;

import java.util.UUID;

public record ProductUpdateDTO(UUID productId, int quantity) {
}