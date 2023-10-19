package org.example.client;

/**
 * thrown when an employee with given id does not exist
 */
public class DoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "An employee with this id doesn't exist";
    }
}
