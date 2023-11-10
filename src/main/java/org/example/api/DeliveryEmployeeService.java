package org.example.api;

import org.example.cli.DeliveryEmployee;
import org.example.cli.DeliveryEmployeeRequest;
import org.example.client.*;
import org.example.core.DeliveryEmployeeValidator;
import org.example.core.EmployeeValidator;
import org.example.db.DeliveryEmployeeDAO;

import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {
    private DeliveryEmployeeDAO dao;
    private EmployeeValidator employeeValidator = new EmployeeValidator();

    private DeliveryEmployeeValidator deliveryEmployeeValidator = new DeliveryEmployeeValidator();

    public DeliveryEmployeeService(DeliveryEmployeeDAO dao){
        this.dao = dao;
    }

    /**
     * Attempts to create a delivery employee using the service data access object
     * @param deliveryEmployee
     * @return the created delivery employee id
     * @throws FailedToCreateException
     */

    public int createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws FailedToCreateDeliveryEmployeeException, InvalidDeliveryEmployeeException {
        DeliveryEmployeeDAO deliveryEmployeeDAO = new DeliveryEmployeeDAO();
        try {
            String validation = deliveryEmployeeValidator.isValidDeliveryEmployee(deliveryEmployee);

            if (validation != null) {
                throw new InvalidDeliveryEmployeeException(validation);
            }

            int id = deliveryEmployeeDAO.createDeliveryEmployee(deliveryEmployee);

            if (id == -1) {
                throw new FailedToCreateDeliveryEmployeeException();
            }

            return id;
        } catch (FailedToCreateException e){
            System.err.println(e.getMessage());

            throw new FailedToCreateDeliveryEmployeeException();
        }
    }

    /**
     * Attempts to update delivery employee's details, uses specific employee ID
     * @param id
     * @param deliveryEmployee
     * @throws ValidationFailedException
     * @throws FailedToUpdateEmployeeException
     */
    public void updateDeliveryEmployee(int id, DeliveryEmployee deliveryEmployee) throws ValidationFailedException, FailedToUpdateEmployeeException, FailedToGetException, DoesNotExistException {

        String error = employeeValidator.isValidEmployee(deliveryEmployee);

        if(error != null){
            throw new ValidationFailedException(error);
        }

        DeliveryEmployee deliveryEmployeeToUpdate = dao.getDeliveryEmployeeById(id);
        if (deliveryEmployeeToUpdate == null) {
            throw new DoesNotExistException();
        }

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

    public List<DeliveryEmployee> getDeliveryEmployees() throws DoesNotExistException, SQLException {

        // Call Get ALL DeliveryEmplyoees
        List<DeliveryEmployee> deliveryEmployeeList = dao.getDeliveryEmployees();
        return deliveryEmployeeList;
    }


    /** Attempts to delete a delivery employee using the service data access object
     * Attempts to delete a delivery employee using the service data access object
     * @param id the id of the delivery employee to delete
     * @throws FailedToDeleteException Thrown if the deletion failed from the data access object
     */
    public void deleteDeliveryEmployee(int id) throws FailedToDeleteException, DoesNotExistException {
        try {

            if(dao.getDeliveryEmployeeById(id) == null){
                throw new DoesNotExistException();
            }
            dao.deleteDeliveryEmployee(id);
        } catch(FailedToGetException e){
            throw new FailedToDeleteException(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

