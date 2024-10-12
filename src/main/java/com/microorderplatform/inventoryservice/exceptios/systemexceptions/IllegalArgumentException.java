package com.microorderplatform.inventoryservice.exceptios.systemexceptions;

public class IllegalArgumentException extends RuntimeException{
    public IllegalArgumentException(String message) {
        super(message);
    }
    public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
