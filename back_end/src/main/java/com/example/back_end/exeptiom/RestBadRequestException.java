package com.example.back_end.exeptiom;

public class RestBadRequestException extends RestException {

    public RestBadRequestException(String message) {
        super(message);
    }
}