package org.example.api;

import org.example.cli.DeliveryEmployee;
import org.example.client.DoesNotExistException;
import org.example.client.FailedToCreateException;
import org.example.client.FailedToGetException;
import org.example.client.FailedToUpdateEmployeeException;
import org.example.client.ValidationFailedException;
import org.example.core.EmployeeValidator;
import org.example.db.DeliveryEmployeeDAO;

import java.sql.SQLException;

public class DeliveryEmployeeService {
    private DeliveryEmployeeDAO dao;
    private EmployeeValidator employeeValidator = new EmployeeValidator();

    public DeliveryEmployeeService(DeliveryEmployeeDAO dao){
        this.dao = dao;
    }

    /**
     * Attempts to create a delivery employee using the service data access object
     * @param deliveryEmployee
     * @return the created delivery employee id
     * @throws FailedToCreateException
     */
    public int createDeliveryEmployee(DeliveryEmployee deliveryEmployee) throws FailedToCreateException, ValidationFailedException {
        String error = employeeValidator.isValidEmployee(deliveryEmployee);
        if(error != null){
            throw new ValidationFailedException(error);
        }
        return dao.createDeliveryEmployee(deliveryEmployee);
    }

    /**
     * Attempts to update delivery employee's details, uses specific employee ID
     * @param id
     * @param deliveryEmployee
     * @throws ValidationFailedException
     * @throws FailedToUpdateEmployeeException
     */
    public void updateDeliveryEmployee(int id, DeliveryEmployee deliveryEmployee) throws ValidationFailedException, FailedToUpdateEmployeeException {

        String error = employeeValidator.isValidEmployee(deliveryEmployee);

        if(error != null){
            throw new ValidationFailedException(error);
        }

//        DeliveryEmployee deliveryEmployeeToUpdate = dao.getEmployeeById(id);
//        if (deliveryEmployeeToUpdate == null) {
//            throw new EmployeeDoesNotExistException();
//        }

        dao.updateDeliveryEmployee(id, deliveryEmployee);
    }

    /**
     * returns specific delivery employee based on employee id
     * @param id employee id
     * @return delivery employee
     * @throws DoesNotExistException if no employee returned from database
     * @throws FailedToGetException if sql statement failed
     */
    public DeliveryEmployee getDeliveryEmployeeById(int id) throws DoesNotExistException, FailedToGetException {

        // call getDeliveryEmployeeById method from DeliveryEmployeeDao class
        DeliveryEmployee deliveryEmployee = dao.getDeliveryEmployeeById(id);

        // if a delivery employee not returned, throw delivery employee does not exist exception
        if(deliveryEmployee == null){
            throw new DoesNotExistException();
        }

        return deliveryEmployee;
    }
}
