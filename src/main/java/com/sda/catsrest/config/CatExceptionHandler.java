package com.sda.catsrest.config;

import com.sda.catsrest.exception.CatNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CatExceptionHandler {

    @ExceptionHandler({CatNotFoundException.class})
    ResponseEntity handleCatNotFoundException(){
        return ResponseEntity.notFound().build();
    }
}
