package com.colak.springannotationsretryabletutorial.exceptions;

public class MyNetworkException extends Exception {

    public MyNetworkException(String message) {
        super(message);
    }
}
