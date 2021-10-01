package com.example.back_end.exeption;

public class RestBadRequestException extends RestException {

    public RestBadRequestException(String message) {
        super(message);
    }
}