package com.microorderplatform.inventoryservice.exceptios.dataexception;

public class ConstraintViolationException extends DataAccessException{
    public ConstraintViolationException(String msg) {
        super(msg);
    }

    public ConstraintViolationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
