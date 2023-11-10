package org.example.client;

public class InvalidDeliveryEmployeeException extends Throwable{
    public InvalidDeliveryEmployeeException(String error) {
        super(error);
    }
}
