package org.example.client;

public class FailedToCreateException extends Throwable {
    public FailedToCreateException(String message){
        super(message);
    }
}
