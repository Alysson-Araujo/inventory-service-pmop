package com.microorderplatform.inventoryservice.producers;


import com.microorderplatform.inventoryservice.DTOs.producer.ProducerMessageInventoryDTO;
import com.microorderplatform.inventoryservice.exceptios.inventoryexception.InvalidInventoryDataException;
import com.microorderplatform.inventoryservice.exceptios.inventoryexception.MessageNotSentException;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.UUID;

import java.util.UUID;

@Component
public class InventoryProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${rabbitmq.exchange.order}")
    private String orderExchange;

    @Value(value = "${rabbitmq.routing.key.inventory.updated}")
    private String inventoryUpdatedRountingKey;

    public void sendMessageAboutInvetory(UUID id, int quantity, boolean isAccepted, boolean productExists) {
        if (id == null) {
            throw new InvalidInventoryDataException("Product ID cannot be null.");
        }
        if (quantity < 0) {
            throw new InvalidInventoryDataException("Quantity cannot be negative.");
        }

        var message = new ProducerMessageInventoryDTO(id, quantity, isAccepted, productExists);

        try {
            rabbitTemplate.convertAndSend(orderExchange, inventoryUpdatedRountingKey, message);
        } catch (Exception e) {
            throw new MessageNotSentException("Failed to send message to RabbitMQ: " + e.getMessage(), e);
        }
    }
}