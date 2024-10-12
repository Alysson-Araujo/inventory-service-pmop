package com.microorderplatform.inventoryservice.exceptios.inventoryexception;

public class InventoryException extends RuntimeException{
    public InventoryException(String message) {
        super(message);
    }
    public InventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
