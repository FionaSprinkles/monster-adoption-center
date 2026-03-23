package com.github.fionasprinkles.monsteradoptioncenter.exception;

public class ResourceNotFoundExceptionHandler extends RuntimeException{

    public ResourceNotFoundExceptionHandler (String message){
        super(message);
    }
}
