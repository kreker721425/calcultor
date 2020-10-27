package com.git.kreker721425.calculator.exception;

public class OperationException extends Exception {

    public OperationException() {
    }

    public String toString() {
        return "ERROR: Знак арифметической операции не найден! Используйте следующие знаки: +, -, *, /";
    }
}
