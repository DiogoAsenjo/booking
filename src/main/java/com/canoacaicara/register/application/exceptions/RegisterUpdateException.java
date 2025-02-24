package com.canoacaicara.register.application.exceptions;

public class RegisterUpdateException extends RuntimeException{
    public RegisterUpdateException(String message) {
        super(message);
    }

    public RegisterUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterUpdateException(Throwable cause) {
        super(cause);
    }
}

