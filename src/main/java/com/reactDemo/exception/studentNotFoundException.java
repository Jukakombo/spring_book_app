package com.reactDemo.exception;

public class studentNotFoundException extends RuntimeException {
    public studentNotFoundException(String message) {
        super(message);
    }
}
