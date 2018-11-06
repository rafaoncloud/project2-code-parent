package servlet;

import dto.Country;
import ejb.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ping")
public class WebflixService
{

    @Inject
    CountryEJB countryEJB;

    @Inject
    MultimediaContentCategoryEJB categoryEJB;

    @Inject
    ManagerEJB managerEJB;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response ping()
    {
       try
       {
            long startTime = System.nanoTime();

            //teste ADD Country
           countryEJB.addAllCountry( "" );

            managerEJB.addManager();

           categoryEJB.addMultimediaContentCategory();

           List<Country> countries  = countryEJB.getAllCountries( "" ,false);

            return Response.ok().entity(countries ).build();

            //return Response.ok().entity("Time: " +  (System.nanoTime() - startTime) ).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
