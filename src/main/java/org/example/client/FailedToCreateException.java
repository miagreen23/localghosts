package org.example.client;

/**
 * failed to create exception thrown if sql create query fails
 */
public class FailedToCreateException extends Throwable {
    public FailedToCreateException(String message){
        super(message);
    }
}
