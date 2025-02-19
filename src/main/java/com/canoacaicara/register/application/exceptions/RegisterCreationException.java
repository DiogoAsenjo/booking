package com.canoacaicara.register.application.exceptions;

public class RegisterCreationException extends RuntimeException{
    public RegisterCreationException(String message) {
        super(message);
    }

    public RegisterCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterCreationException(Throwable cause) {
        super(cause);
    }
}

