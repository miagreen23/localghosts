package org.example.api;

import org.example.cli.DeliveryEmployee;
import org.example.client.FailedToCreateException;
import org.example.client.FailedToDeleteException;
import org.example.client.ValidationFailedException;
import org.example.core.EmployeeValidator;
import org.example.db.DeliveryEmployeeDAO;

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
     * Attempts to delete a delivery employee using the service data access object
     * @param id the id of the delivery employee to delete
     * @throws FailedToDeleteException Thrown if the deletion failed from the data access object
     */
    public void deleteDeliveryEmployee(int id) throws FailedToDeleteException {
        dao.deleteDeliveryEmployee(id);
    }
}
