package servlet;

import dto.EMultimediaContentCategory;
import ejb.multimediacontent.MultimediaContentEJB;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/content")
public class MultimediaContent {

    //@EJB
    private MultimediaContentEJB multimediaContentEJB;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMultimediaContent(@PathParam("id") final long id, @QueryParam("token") final String token){

        try {
            //dto.MultimediaContent content =  multimediaContentEJB.getMultimediaContent("aa",id);

            dto.MultimediaContent content = new dto.MultimediaContent();
            content.setId(id);
            content.setCategory(EMultimediaContentCategory.ACTION);
            content.setContentPath("https://www.moviesmonster.online/tomb-raider.html");
            content.setTitle("Tomb Rider");
            content.setYearOfRelease(2018);
            content.setDirectorName("Roar Uthaug");
            content.setUsers(null);

            return Response.ok(content).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMultimediaContent(@NotNull @QueryParam("token") final String token, @QueryParam("order") final String order){

        Boolean isOrderAsc = orderByAscOrDesc(order);
        if(isOrderAsc == null) // User wrote some wrong order string value (not asc or desc)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();

        try {
            List<dto.MultimediaContent> contentList = multimediaContentEJB.getMultimediaContent(token,isOrderAsc);
            return Response.ok(contentList).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMultimediaContentByYearRange(@NotNull @QueryParam("token") final String token,
                                         @NotNull @QueryParam("minyear") final int minYear,@NotNull @QueryParam("maxyear") final int maxYear, @QueryParam("order") String order){
        Boolean isOrderAsc = orderByAscOrDesc(order);
        if(isOrderAsc == null) // User wrote some wrong order string value (not asc or desc)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();

        try {
            List<dto.MultimediaContent> contentList = multimediaContentEJB.getMultimediaContentBetweenYearsRange(token,minYear,maxYear,isOrderAsc);
            return Response.ok(contentList).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMultimediaContentByDirectorName(@NotNull @QueryParam("token") final String token,
                                         @NotNull @QueryParam("director") final String director, @QueryParam("order") String order){
        Boolean isOrderAsc = orderByAscOrDesc(order);
        if(isOrderAsc == null) // User wrote some wrong order string value (not asc or desc)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();

        try {
            List<dto.MultimediaContent> contentList = multimediaContentEJB.getMultimediaContentFromDirector(token,director,isOrderAsc);
            return Response.ok(contentList).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMultimediaContent(@NotNull @QueryParam("token") final String token,
                                         @NotNull @QueryParam("category") final String category, @QueryParam("order") String order){
        Boolean isOrderAsc = orderByAscOrDesc(order);
        if(isOrderAsc == null) // User wrote some wrong order string value (not asc or desc)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();

        try {
            List<dto.MultimediaContent> contentList = multimediaContentEJB.getMultimediaContentFromCategory(token,dto.EMultimediaContentCategory.valueOf(category.toUpperCase()),isOrderAsc);
            return Response.ok(contentList).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMultimediaContent(@NotNull @QueryParam("token") final String token,
                                         @NotNull @PathParam("id") final long id){

        try {
            multimediaContentEJB.deleteMultimediaContent(token,id);
            return Response.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMultimediaContent(@NotNull @QueryParam("token") final String token, @NotNull final dto.MultimediaContent content){

        System.out.println(content.toString()); // Debug

        try {
            multimediaContentEJB.addMultimediaContent(token,content);
            return Response.accepted(content).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Consumes("application/json;charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMultimediaContent(@NotNull @QueryParam("token") final String token, @NotNull final dto.MultimediaContent content){

        System.out.println(content.toString()); // Debug

        try {
            multimediaContentEJB.updateMultimediaContent(token,content);
            return Response.accepted(content).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Boolean orderByAscOrDesc(String order){

        boolean isOrderAsc = true;

        if(order != null) {
            if (order.equalsIgnoreCase("asc"))
                isOrderAsc = true;
            else if (order.equalsIgnoreCase("des"))
                isOrderAsc = true;
            else
                return null;
        }

        return true;
    }
}
