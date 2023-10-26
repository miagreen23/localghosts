package org.example.client;

public class FailedToCreateDeliveryEmployeeException extends Throwable{
    @Override
    public String getMessage() {
        return "Failed to create delivery employee in the database";
    }
}
