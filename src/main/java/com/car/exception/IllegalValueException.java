package com.car.exception;

public class IllegalValueException extends RuntimeException {
    public IllegalValueException(String errorMessage) {
        super(errorMessage);
    }
}
