package com.example.VacationPayCalculator.exception;

public class NotEnoughSalaryException extends RuntimeException{
    public NotEnoughSalaryException(String massage) {
        super(massage);
    }
}
