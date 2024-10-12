package com.microorderplatform.inventoryservice.exceptios.amqpexcpetions;

import org.springframework.amqp.AmqpException;

public class MessageConversionException extends AmqpException {
    public MessageConversionException(String message) {
        super(message);
    }
    public MessageConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
