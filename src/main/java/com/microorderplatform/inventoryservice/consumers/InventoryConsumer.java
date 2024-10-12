package com.microorderplatform.inventoryservice.consumers;


import com.microorderplatform.inventoryservice.DTOs.consumer.OrderCreatedDTO;
import com.microorderplatform.inventoryservice.exceptios.inventoryexception.MessageNotSentException;
import com.microorderplatform.inventoryservice.exceptios.inventoryexception.ProductNotFoundException;
import com.microorderplatform.inventoryservice.models.InventoryModel;
import com.microorderplatform.inventoryservice.models.ProductModel;
import com.microorderplatform.inventoryservice.producers.InventoryProducer;
import com.microorderplatform.inventoryservice.services.Inventory.InventoryService;
import com.microorderplatform.inventoryservice.services.Product.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class InventoryConsumer {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryProducer inventoryProducer;

    @RabbitListener(queues = "${rabbitmq.queue.order.created}")
    public void receiveMessage(@Payload OrderCreatedDTO orderCreatedDTO) {
        try {

            InventoryModel inventoryModel = inventoryService.findInventoryByProductId(orderCreatedDTO.productId());

            if (inventoryModel == null) {
                throw new ProductNotFoundException("Product with ID " + orderCreatedDTO.productId() + " not found in inventory.");
            }

            boolean isAccepted = inventoryModel.getQuantity() >= orderCreatedDTO.quantity();
            inventoryProducer.sendMessageAboutInvetory(orderCreatedDTO.productId(), orderCreatedDTO.quantity(), isAccepted, true);
        } catch (ProductNotFoundException e) {
            inventoryProducer.sendMessageAboutInvetory(orderCreatedDTO.productId(), orderCreatedDTO.quantity(), false, false);
        } catch (Exception e) {
            throw new MessageNotSentException("Failed to send message to RabbitMQ: " + e.getMessage(), e);
        }
    }
}
