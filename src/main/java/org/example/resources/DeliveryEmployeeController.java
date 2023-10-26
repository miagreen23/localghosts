package org.example.resources;

import org.example.api.DeliveryEmployeeService;
import org.example.cli.DeliveryEmployee;
import org.example.cli.DeliveryEmployeeRequest;
import org.example.client.*;
import io.swagger.annotations.Api;
import org.example.db.DeliveryEmployeeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Java beans Kainoos api")
@Path("/api")
public class DeliveryEmployeeController {

    // Instantiates DeliveryEmployee service, passes through DeliveryEmployee DAO
    DeliveryEmployeeService deliveryEmployeeService = new DeliveryEmployeeService(new DeliveryEmployeeDAO());
    // GET route to capture all employees in DB
    @GET
    @Path("/employee/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees(){
        try {
            return Response.ok().entity(deliveryEmployeeService.getDeliveryEmployees()).build();
        } catch (SQLException | DoesNotExistException e) {
            return Response.serverError().build();
        }
    }

    // POST route to create a new delivery employee in DB
    @POST
    @Path("/employee/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) {
        try {
            return Response.ok(deliveryEmployeeService.createDeliveryEmployee(deliveryEmployee)).build();
        } catch (FailedToCreateDeliveryEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().entity(e.getMessage()).build();
        } catch (InvalidDeliveryEmployeeException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    /**
     * gets first name, last name, salary, bank account number of a delivery employee based on the employee id
     * @param id employee id of employee
     * @return id of employee
     */
    @GET
    @Path("/employee/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeById(@PathParam("id") int id){
        try {
            // response 200 ok, return delivery employee id
            return Response.ok(deliveryEmployeeService.getDeliveryEmployeeById(id)).build();
        } catch (DoesNotExistException e) {
            System.err.println(e.getMessage());
            // response 400 bad request, delivery employee requested doesn't exist
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (FailedToGetException e) {
            System.err.println(e.getMessage());
            // response 500 internal server error, sql query failure
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


    /**
     * PUT route to update a specified delivery employee's name, salary and bank account details
     * @param id
     * @param deliveryEmployee
     * @return a Response depending on outcome of PUT
     */
    @PUT
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryEmployee(@PathParam("id") int id, DeliveryEmployee deliveryEmployee) {
        try {
            deliveryEmployeeService.updateDeliveryEmployee(id, deliveryEmployee);
            return Response.ok().build();

        } catch (ValidationFailedException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (FailedToUpdateEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (DoesNotExistException | FailedToGetException e) {
            throw new RuntimeException(e);
        }
    }
}
