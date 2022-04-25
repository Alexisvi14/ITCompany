package com.solvd.exceptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {}

    public InvalidAmountException(String message) {
        super(message);
    }

    public InvalidAmountException(String message, Throwable t) {
        super(message, t);
    }
}
