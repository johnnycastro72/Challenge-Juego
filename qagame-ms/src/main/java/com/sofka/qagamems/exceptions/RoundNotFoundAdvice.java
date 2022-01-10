package com.sofka.qagamems.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class RoundNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RoundNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String RoundNotFountAdvice(RoundNotFoundException ex) {
        return ex.getMessage();
    }
}
