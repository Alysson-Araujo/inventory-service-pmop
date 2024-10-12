package com.microorderplatform.inventoryservice.exceptios.inventoryexception;

public class InvalidInventoryDataException extends InventoryException{
    public InvalidInventoryDataException(String message) {
        super(message);
    }
    public InvalidInventoryDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
