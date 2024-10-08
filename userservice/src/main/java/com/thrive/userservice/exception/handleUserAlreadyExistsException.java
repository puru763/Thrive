package com.thrive.userservice.exception;

public class handleUserAlreadyExistsException extends RuntimeException{
    public handleUserAlreadyExistsException(String message) {
        super(message);
    }
}
