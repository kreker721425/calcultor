package com.git.kreker721425.calculator.exception;

public class NumberOfArgumentsException extends Exception {

    public NumberOfArgumentsException() {
    }

    public String toString() {
        return "ERROR: Число аргументов больше двух! Используйте только два аргумента";
    }
}
