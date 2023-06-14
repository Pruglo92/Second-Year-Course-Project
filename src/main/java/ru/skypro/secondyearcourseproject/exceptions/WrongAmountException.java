package ru.skypro.secondyearcourseproject.exceptions;

public class WrongAmountException extends RuntimeException {
    public WrongAmountException(String message) {
        super(message);
    }
}
