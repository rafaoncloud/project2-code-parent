package admin;

import dto.Country;
import dto.Manager;
import dto.MultimediaContent;
import ejb.*;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class AdminController {

    @Inject
    private ManagerEJB managerEJB;
    @Inject
    private UserEJB userEJB;
    @Inject
    private CountryEJB countryEJB;
    @Inject
    private MultimediaContentCategoryEJB categoryEJB;
    @Inject
    private MultimediaContentEJB multimediaContentEJB;

    @GET
    @Path("/populate")
    @Produces({MediaType.APPLICATION_JSON})
    public Response populate(){
        try{
            countryEJB.addAllCountry("");
            managerEJB.addManager();
            categoryEJB.addMultimediaContentCategory();

            List<Country> countries  = countryEJB.getAllCountries( "" ,false);

            return Response.ok(countries).build();
        }catch (Exception e){
            utils.Utils.getLogger().error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/populate-content")
    @Produces({MediaType.APPLICATION_JSON})
    public Response populateWithMultimediaContent(){
        try{
            List<dto.MultimediaContentCategory> cat = categoryEJB.getAllMultimediaContentCategory("",false);

            List<dto.MultimediaContent> multimediaContents = new ArrayList<>();
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","The Shawshank Redemption",
                    cat.get(4), 1994,"Frank Darabont"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Godfather",
                    cat.get(3), 1972,"Francis Ford Coppola"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","The Dark Knight",
                    cat.get(0), 2008,"Christopher Nolan"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","The Godfather: Part II",
                    cat.get(3), 1974,"Christopher Nolan"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Pulp Fiction",
                    cat.get(4), 1974,"Quentin Tarantino"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Schindler's List",
                    cat.get(6), 1993,"Steven Spielberg"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","The Lord of the Rings: The Return of the King",
                    cat.get(0), 2003,"Peter Jackson"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","The Good, the Bad nad the Ugly",
                    cat.get(0), 1966,"Sergio Leone"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","12 Angry Men",
                    cat.get(3), 1957,"Sidney Lumet"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Inception",
                    cat.get(0), 2010,"Christopher Nolan"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","The Lord of the Rings: The Fellowship of the Ring",
                    cat.get(0), 2001,"Peter Jackson"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Forest Gump",
                    cat.get(4), 1994,"Robert Zemeckis"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Fight Club",
                    cat.get(4), 1999,"David Fincher"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Star Wars: Episode V - The Empire Strikes Back",
                    cat.get(0), 1980,"Irvin Kershner"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","The Matrix",
                    cat.get(0), 1999,"Lana Wachowski"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Godfellas",
                    cat.get(3), 1990,"Martin Scorsese"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath"," One Flew Over the Cuckoo's Nest",
                    cat.get(4), 1975,"Milos Forman"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","The Lord of the Rings: The Two Towers",
                    cat.get(1), 2002,"Peter Jackson"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Seven Samurai",
                    cat.get(1), 1954,"Akira Kurosawa"));
            multimediaContents.add(new MultimediaContent(-1,"/randomPath","Avengers: Infinite War",
                    cat.get(0), 2018,"Anthony Russo"));

                multimediaContentEJB.adminOnlyAddMultimediaContent(multimediaContents);

            return Response.ok(multimediaContents).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    //
    // MANAGER
    //

    @GET
    @Path("/manager")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllManagers(){
        try{
            List<dto.Manager> managers = managerEJB.getAllManagers("");

            return Response.ok(managers).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/manager/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getManager(@PathParam("id") @NotNull long id){
        try{
            dto.Manager manager = managerEJB.getManager(id);

            return Response.ok(manager).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/manager")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addManager(@NotNull Manager manager){
        try{
            managerEJB.addManager(manager);
            return Response.status(Response.Status.CREATED).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/manager/{id}")
    public Response deleteManager(@PathParam("id") @NotNull long id){
        try{
            managerEJB.deleteManager("",id);
            return Response.status(Response.Status.ACCEPTED).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    //
    // USER
    //

    @GET
    @Path("/user")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUsers(){
        try{
            List<dto.User> users = userEJB.adminOnlyListAllUsers();

            return Response.ok(users).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/user/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateSubscriptionUser(@PathParam("id") @NotNull long id,@QueryParam("subscribed") @NotNull String isSubscribed){
        try{

            Boolean isSubscribedFormat = null;
            if(isSubscribed.equalsIgnoreCase("on"))
                isSubscribedFormat = true;
            else if (isSubscribed.equalsIgnoreCase("off"))
                isSubscribedFormat = false;

            if(isSubscribedFormat != null){
                userEJB.adminOnlyUpdateUserSubscription(id,isSubscribedFormat);
            }
            dto.User user = userEJB.adminOnlyGetUser(id);

            return Response.ok(user).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
