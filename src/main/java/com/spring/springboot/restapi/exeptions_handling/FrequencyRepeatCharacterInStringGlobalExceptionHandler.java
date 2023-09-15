package com.spring.springboot.restapi.exeptions_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FrequencyRepeatCharacterInStringGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectRequest> handleException (EmptyOrNullRequestException exception) {

        IncorrectRequest request = new IncorrectRequest();
        request.setMessage(exception.getMessage());
        request.setStatusCode("Code: " + HttpStatus.BAD_REQUEST.value() + " status: " + HttpStatus.BAD_REQUEST.name());

        return new ResponseEntity<>(request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectRequest> handleException (LengthStringRequestException exception) {

        IncorrectRequest request = new IncorrectRequest();
        request.setMessage(exception.getMessage());
        request.setStatusCode(
                "Code: " + HttpStatus.LENGTH_REQUIRED.value() +
                " status: " + HttpStatus.LENGTH_REQUIRED.name()
        );

        return new ResponseEntity<>(request, HttpStatus.LENGTH_REQUIRED);
    }

}
