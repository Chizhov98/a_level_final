package com.example.back_end.exeption;

public class RestException extends RuntimeException {

    public RestException(String message) {
        super(message);
    }
}