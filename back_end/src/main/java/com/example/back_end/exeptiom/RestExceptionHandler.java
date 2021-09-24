package com.example.back_end.exeptiom;
import com.example.back_end.api.dto.response.DataContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = RestBadRequestException.class)
    public ResponseEntity<DataContainer<String>> handleBadRequest(RestBadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DataContainer<>(exception.getMessage()));
    }
}
