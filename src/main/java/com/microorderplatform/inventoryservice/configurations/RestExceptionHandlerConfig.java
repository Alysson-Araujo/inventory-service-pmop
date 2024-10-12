package com.microorderplatform.inventoryservice.configurations;



import com.microorderplatform.inventoryservice.exceptios.BodyException;
import com.microorderplatform.inventoryservice.exceptios.dataexception.DataIntegrityViolationException;
import com.microorderplatform.inventoryservice.exceptios.inventoryexception.InvalidInventoryDataException;
import com.microorderplatform.inventoryservice.exceptios.inventoryexception.InventoryException;
import com.microorderplatform.inventoryservice.exceptios.inventoryexception.InventoryUpdateException;
import com.microorderplatform.inventoryservice.exceptios.inventoryexception.MessageNotSentException;
import com.microorderplatform.inventoryservice.utils.ErrorResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestExceptionHandlerConfig {

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<BodyException> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "Data Integrity Violation",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<BodyException> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "Malformed JSON request",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<BodyException> handleIllegalArgumentException(IllegalArgumentException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "Invalid Argument",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<BodyException> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "Method Argument Not Valid",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<BodyException> handleNoSuchElementException(NoSuchElementException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "No Such Element",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity<BodyException> handleNullPointerException(NullPointerException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "Null Pointer Exception",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InventoryUpdateException.class)
    private ResponseEntity<BodyException> handleInventoryException(InventoryException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "Inventory Error",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MessageNotSentException.class)
    private ResponseEntity<BodyException> handleMessageNotSentException(MessageNotSentException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "Message Not Sent",
                HttpStatus.SERVICE_UNAVAILABLE
        );
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(InvalidInventoryDataException.class)
    private ResponseEntity<BodyException> handleInvalidInventoryDataException(InvalidInventoryDataException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(
                exception.getMessage(),
                "Invalid Inventory Data",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
