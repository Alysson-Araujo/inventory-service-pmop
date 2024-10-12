package com.microorderplatform.inventoryservice.exceptios.amqpexcpetions;


import org.springframework.amqp.AmqpException;

public class MessageRejectedException extends AmqpException {
    public MessageRejectedException(String message) {
        super(message);
    }
    public MessageRejectedException(String message, Throwable cause) {
        super(message, cause);
    }
}
