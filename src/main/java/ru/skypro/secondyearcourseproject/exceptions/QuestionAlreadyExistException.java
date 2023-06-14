package ru.skypro.secondyearcourseproject.exceptions;

public class QuestionAlreadyExistException extends RuntimeException {
    public QuestionAlreadyExistException(String message) {
        super(message);
    }
}
