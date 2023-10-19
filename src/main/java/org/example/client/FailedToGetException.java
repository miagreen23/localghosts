package org.example.client;

public class FailedToGetException extends Throwable {
    public FailedToGetException(String message){
        super(message);
    }
}
