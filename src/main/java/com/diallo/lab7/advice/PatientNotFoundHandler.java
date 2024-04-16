package com.diallo.lab7.advice;


import com.diallo.lab7.exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class PatientNotFoundHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PatientNotFoundException.class)
    public Map<String, String> handlePatientNotFound(PatientNotFoundException e) {

        Map<String, String> map = new HashMap<>();
        map.put("Patient not found", e.getMessage());
        return map;
    }

}
