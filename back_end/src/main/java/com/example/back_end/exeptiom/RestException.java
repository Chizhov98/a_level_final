package com.example.back_end.exeptiom;

public class RestException extends RuntimeException {

    public RestException(String message) {
        super(message);
    }
}