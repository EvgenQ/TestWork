package com.spring.springboot.restapi.exeptions_handling;

public class IncorrectRequest {

    private String message;
    private String statusCode;

    public IncorrectRequest() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
