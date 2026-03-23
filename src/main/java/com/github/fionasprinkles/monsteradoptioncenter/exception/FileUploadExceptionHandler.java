package com.github.fionasprinkles.monsteradoptioncenter.exception;

import com.github.fionasprinkles.monsteradoptioncenter.dto.CreateMonsterDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class FileUploadExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView handleMaxSize(MaxUploadSizeExceededException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("createMonsterDTO", new CreateMonsterDTO());

        modelAndView.addObject("bindingResult", null);
        modelAndView.addObject("error" , "File Upload Limit Exceeded. Max 10MB");

        modelAndView.setViewName("monsters/new");
        return modelAndView;
    }
}
