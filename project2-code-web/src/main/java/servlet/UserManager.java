package servlet;

import dto.User;
import ejb.user.UserEJB;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserManager {

    //@EJB
    UserEJB userEJB;

    @POST
    public Response addUser(@NotNull final User user){

        try {
            userEJB.addUser(user);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@NotNull final String token, @PathParam("id") @NotNull final long id){

        try {
            dto.User user =  userEJB.getUser(token,id);
            return Response.ok(user).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    @PUT
    public Response updateUser(@NotNull final String token, @NotNull final User user){

        try {
            userEJB.updateUser(token,user);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@NotNull final String token, @NotNull @PathParam("id")final long id){

        try {
            userEJB.deleteUser(token,id);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
}
