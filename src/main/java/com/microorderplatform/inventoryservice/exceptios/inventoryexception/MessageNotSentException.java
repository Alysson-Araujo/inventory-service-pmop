package com.microorderplatform.inventoryservice.exceptios.inventoryexception;

public class MessageNotSentException extends InventoryException{
    public MessageNotSentException(String message) {
        super(message);
    }
    public MessageNotSentException(String message, Throwable cause) {
        super(message, cause);
    }
}
