package com.studentManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IOException.class)
    public ModelAndView handleCustomException(IOException ex)
    {
        ModelAndView modelAndView = new ModelAndView("error");
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), 500);
        modelAndView.addObject("error", errorResponse);
        return modelAndView;
    }
}
