package com.canoacaicara.booking.reservation.controller;

import com.canoacaicara.booking.reservation.exception.ReservationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ReservationController.class)
public class ReservationExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(ReservationNotFoundException exc) {

        ReservationErrorResponse error = new ReservationErrorResponse();

        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(Exception exc) {

        ReservationErrorResponse error = new ReservationErrorResponse();

        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ReservationErrorResponse> handleException(MethodArgumentNotValidException exc) {

        ReservationErrorResponse error = new ReservationErrorResponse();

        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        String errorMessage = exc.getBindingResult().getFieldError().getDefaultMessage();
        error.setMessage(errorMessage);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
