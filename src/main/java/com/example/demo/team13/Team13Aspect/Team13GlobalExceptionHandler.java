package com.example.demo.team13.Team13Aspect;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Team13GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {

        model.addAttribute("errorSource", ex.getClass().getSimpleName());
        model.addAttribute("errorMessage", ex.getMessage());

        return "team13/Team13_Error";
    }
}
