package com.spring.springboot.restapi.exeptions_handling;

public class LengthStringRequestException extends RuntimeException {
    public LengthStringRequestException(String message) {
        super(message);
    }
}
