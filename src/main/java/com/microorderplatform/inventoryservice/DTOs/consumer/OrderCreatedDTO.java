package com.microorderplatform.inventoryservice.DTOs.consumer;

import java.util.UUID;

public record OrderCreatedDTO(UUID id,
                              UUID productId,
                              UUID orderId,
                              int quantity,
                              double unitPrice) {
}
