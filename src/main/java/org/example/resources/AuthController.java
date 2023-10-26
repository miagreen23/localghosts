package org.example.resources;

import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.example.api.AuthService;
import org.example.cli.Login;
import org.example.client.FailedToGenerateTokenException;
import org.example.client.FailedToLoginException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("localghosts Dropwizard Auth API")
@Path("/api")

public class AuthController {
    private AuthService authService = new AuthService();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Login login) {
        try {
            return Response.ok(authService.login(login)).build();
        } catch (FailedToLoginException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToGenerateTokenException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
