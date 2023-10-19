package org.example.resources;

import io.swagger.annotations.Api;
import org.example.db.DeliveryEmployeeDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Java beans Kainoos api")
@Path("/api")
public class DeliveryEmployeeController {

    @GET
    @Path("/deliveryemployees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testDAO(){
        DeliveryEmployeeDAO employeeDAO = new DeliveryEmployeeDAO();
        return Response.ok().entity(employeeDAO.getDeliveryEmployeesIds()).build();
    }
}
