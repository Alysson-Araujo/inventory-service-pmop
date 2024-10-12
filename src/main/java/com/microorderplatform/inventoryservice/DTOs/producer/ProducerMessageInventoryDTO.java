package com.microorderplatform.inventoryservice.DTOs.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProducerMessageInventoryDTO {
    private UUID productId;
    private int quantity;
    private boolean isAccepted;
    private boolean productExists;

}
