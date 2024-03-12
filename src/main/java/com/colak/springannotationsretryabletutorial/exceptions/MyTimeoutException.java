package com.colak.springannotationsretryabletutorial.exceptions;

public class MyTimeoutException extends Exception {
    public MyTimeoutException(String message) {
        super(message);
    }
}
