package com.jpa.lab4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NullEntityReferenceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView nullEntityReferenceExceptionHandler(NullEntityReferenceException e) {
        ModelAndView modelAndView = new ModelAndView("500", HttpStatus.BAD_REQUEST);
        modelAndView.addObject("info", e.getMessage());
        return modelAndView;
    }
}
