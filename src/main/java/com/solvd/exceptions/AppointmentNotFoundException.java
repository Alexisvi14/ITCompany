package com.solvd.exceptions;

public class AppointmentNotFoundException extends RuntimeException{
    public AppointmentNotFoundException() {}

    public AppointmentNotFoundException(String message) {
        super(message);
    }

    public AppointmentNotFoundException(String message, Throwable t) {
        super(message, t);
    }
}
