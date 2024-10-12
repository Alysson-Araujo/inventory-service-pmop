package com.microorderplatform.inventoryservice.DTOs;

import java.util.UUID;

public record InventoryDTO (UUID idProduct,
                            int quantity) {
}
