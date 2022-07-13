package com.demo.rest_demo.Rest;

public class StudentNotFountException extends RuntimeException{


    public StudentNotFountException(String message) {
        super(message);
    }

    public StudentNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFountException(Throwable cause) {
        super(cause);
    }


}
