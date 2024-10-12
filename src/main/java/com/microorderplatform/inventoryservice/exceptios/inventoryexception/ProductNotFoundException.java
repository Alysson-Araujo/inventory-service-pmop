package com.microorderplatform.inventoryservice.exceptios.inventoryexception;

public class ProductNotFoundException extends InventoryException{
    public ProductNotFoundException(String message) {
        super(message);
    }
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
