package com.microorderplatform.inventoryservice.exceptios.inventoryexception;

public class InsufficientStockException extends InventoryException{
    public InsufficientStockException(String message) {
        super(message);
    }
    public InsufficientStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
