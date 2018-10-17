package servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class WebflixService {

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response hi(){
        return Response.ok().entity("Hi").build();
    }

}
