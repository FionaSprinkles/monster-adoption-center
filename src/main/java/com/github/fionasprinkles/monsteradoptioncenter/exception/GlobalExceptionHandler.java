package com.github.fionasprinkles.monsteradoptioncenter.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleNotFound(ResourceNotFoundException ex, Model model) {

        model.addAttribute("errorTitle", "404 - Not found");
        model.addAttribute("errorMessage", "The monster you tried to access does not exist.");

        return "error/not-found";
    }
}
