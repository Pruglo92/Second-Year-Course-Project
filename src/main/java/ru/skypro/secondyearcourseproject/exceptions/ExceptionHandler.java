package ru.skypro.secondyearcourseproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(WrongAmountException.class)
    public ResponseEntity<String> wrongAmountExceptionHandler(WrongAmountException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(QuestionAlreadyExistException.class)
    public ResponseEntity<String> questionAlreadyExistExceptionHandler(QuestionAlreadyExistException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<String> questionNotFoundExceptionHandler(QuestionNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
