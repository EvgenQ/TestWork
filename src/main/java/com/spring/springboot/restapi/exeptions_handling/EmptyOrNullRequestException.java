package com.spring.springboot.restapi.exeptions_handling;

public class EmptyOrNullRequestException extends RuntimeException{
    public EmptyOrNullRequestException(String message) {
        super(message);
    }
}
