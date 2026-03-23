package com.github.fionasprinkles.monsteradoptioncenter.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExceptionHandler.class)
    public String handleNotFound(ResourceNotFoundExceptionHandler ex, Model model) {

        model.addAttribute("error", ex.getMessage());

        return "error/not-found.jte";
    }
}
