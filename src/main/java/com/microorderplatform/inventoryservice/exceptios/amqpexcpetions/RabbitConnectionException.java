package com.microorderplatform.inventoryservice.exceptios.amqpexcpetions;

import org.springframework.amqp.AmqpException;

public class RabbitConnectionException extends AmqpException {
    public RabbitConnectionException(String message) {
        super(message);
    }
    public RabbitConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
