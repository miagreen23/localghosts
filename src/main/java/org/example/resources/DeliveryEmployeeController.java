package org.example.resources;

import org.example.api.DeliveryEmployeeService;
import org.example.cli.DeliveryEmployee;
import org.example.client.FailedToCreateException;
import org.example.client.ValidationFailedException;
import io.swagger.annotations.Api;
import org.example.db.DeliveryEmployeeDAO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        DeliveryEmployeeDAO employeeDAO = new DeliveryEmployeeDAO();
        return Response.ok().entity(employeeDAO.getDeliveryEmployeesIds()).build();
    }

    // POST route to create a new delivery employee in DB
    @POST
    @Path("/employee/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(DeliveryEmployee deliveryEmployee) {
        try {
            return Response.ok(deliveryEmployeeService.createDeliveryEmployee(deliveryEmployee)).build();
        } catch (FailedToCreateException e) {
            System.err.println(e.getMessage());
            return Response.serverError().entity(e.getMessage()).build();
        } catch (ValidationFailedException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
