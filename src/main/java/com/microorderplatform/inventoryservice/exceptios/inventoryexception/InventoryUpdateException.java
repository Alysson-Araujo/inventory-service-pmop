package com.microorderplatform.inventoryservice.exceptios.inventoryexception;

public class InventoryUpdateException extends InventoryException{
    public InventoryUpdateException(String message) {
        super(message);
    }
    public InventoryUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
