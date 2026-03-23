package com.github.fionasprinkles.monsteradoptioncenter.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
