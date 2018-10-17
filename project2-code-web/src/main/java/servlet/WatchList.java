package servlet;

import ejb.UserEJB;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/watch-list")
public class WatchList {

    //@EJB
    UserEJB userEJB;

    @GET
    public Response getWatchList(@NotNull final String token){
        return Response.noContent().build();
    }

    @POST
    public Response addContentToWatchList(@NotNull final String token, @NotNull final long id){
        return Response.noContent().build();
    }

    @DELETE
    public Response removeContentFromWatchList(@NotNull final String token, @NotNull final long id){
        return Response.noContent().build();
    }
}
