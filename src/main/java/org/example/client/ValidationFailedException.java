package org.example.client;

public class ValidationFailedException extends Throwable {
    public ValidationFailedException(String message){
        super(message);
    }
}
