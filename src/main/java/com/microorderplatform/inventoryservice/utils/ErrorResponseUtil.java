package com.microorderplatform.inventoryservice.utils;

import com.microorderplatform.inventoryservice.exceptios.BodyException;
import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ErrorResponseUtil {
    public static BodyException buildErrorResponse(String message, String error, HttpStatus status) {
        return new BodyException(
                message,
                error,
                status.toString(),
                Instant.now().toString()
        );
    }
}
