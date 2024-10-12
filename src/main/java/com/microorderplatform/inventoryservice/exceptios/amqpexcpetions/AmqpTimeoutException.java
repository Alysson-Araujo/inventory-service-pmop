package com.microorderplatform.inventoryservice.exceptios.amqpexcpetions;

import org.springframework.amqp.AmqpException;

public class AmqpTimeoutException extends AmqpException {
    public AmqpTimeoutException(String message) {
        super(message);
    }

    public AmqpTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
