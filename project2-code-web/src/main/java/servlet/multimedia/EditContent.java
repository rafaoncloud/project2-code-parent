package servlet.multimedia;

import dto.MultimediaContent;
import dto.MultimediaContentCategory;
import ejb.MultimediaContentCategoryEJB;
import ejb.MultimediaContentEJB;
import notifications.NotificationsManager;
import utils.Utils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/multimedia/editContent")
public class EditContent extends HttpServlet
{

    @Inject
    MultimediaContentCategoryEJB categoryEJB;


    @Inject
    MultimediaContentEJB multimediaEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            if (request.getSession().getAttribute("id") == null || !request.getSession().getAttribute("userType").equals( Utils.UserType.Manager))
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            String token =  request.getSession().getAttribute("token").toString();

            List<MultimediaContentCategory> categories  = categoryEJB.getAllMultimediaContentCategory( token ,false);
            request.setAttribute("categories",categories);

            String multimediaContentId = request.getParameter("id");

            if(multimediaContentId == null)
            {
                response.sendRedirect("multimediaContent.jsp");
                return;
            }

            dto.MultimediaContent multimediaContent = multimediaEJB.getMultimediaContent(  token, Long.parseLong( multimediaContentId));

            request.setAttribute("id",multimediaContent.getId());
            request.setAttribute("title",multimediaContent.getTitle());
            request.setAttribute("yearOfRelease",multimediaContent.getYearOfRelease());
            request.setAttribute("directorName",multimediaContent.getDirectorName());
            request.setAttribute("categoryId",multimediaContent.getCategory().getId());

            request.getRequestDispatcher("editContent.jsp").forward(request, response);

        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("multimediaContent.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            if (request.getSession().getAttribute("id") == null || !request.getSession().getAttribute("userType").equals( Utils.UserType.Manager))
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            dto.MultimediaContent multimediaContent = new dto.MultimediaContent();

            multimediaContent.setId( Long.parseLong(request.getParameter("id")));
            multimediaContent.setTitle( request.getParameter("title"));
            multimediaContent.setYearOfRelease( Integer.parseInt(request.getParameter("yearOfRelease")));
            multimediaContent.setDirectorName( request.getParameter("directorName"));

            long categoryId = Long.parseLong(request.getParameter( "category" ));

            MultimediaContentCategory category = categoryEJB.getMultimediaContentCategory((String) request.getSession().getAttribute("token"), categoryId);

            multimediaContent.setCategory(category );

            multimediaEJB.updateMultimediaContent((String)request.getSession().getAttribute("token"), multimediaContent);

            NotificationsManager.addSuccessMessage(request.getSession().getId(), "Multimedia Content updated successfully.");


            response.sendRedirect("multimediaContent");
        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("../index.jsp");
        }
    }

}

