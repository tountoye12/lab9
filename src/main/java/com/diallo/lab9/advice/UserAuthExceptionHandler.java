package com.diallo.lab9.advice;


import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;
import java.util.Map;

@RestControllerAdvice
public class UserAuthExceptionHandler {

    @ExceptionHandler({BadCredentialsException.class, SignatureException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleBadCredentialsException(BadCredentialsException e) {
        return Map.of("error", e.getMessage());
    }
}
