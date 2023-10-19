package org.example.client;

public class FailedToDeleteException extends Throwable {
    public FailedToDeleteException(String message) {
        super(message);
    }
}
