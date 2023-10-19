package org.example.client;

public class FailedToUpdateEmployeeException extends Throwable {
    public FailedToUpdateEmployeeException(String message){
        super(message);
    }
}
