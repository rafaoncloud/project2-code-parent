package servlet.multimedia;

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

@WebServlet("/multimedia/deleteContent")
public class DeleteContent extends HttpServlet
{

    @Inject
    MultimediaContentEJB multimediaEJB;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            if (request.getSession().getAttribute("id") == null || !request.getSession().getAttribute("userType").equals( Utils.UserType.Manager))
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            String token =  request.getSession().getAttribute("token").toString();


            String multimediaContentId = request.getParameter("dMContentId");


            dto.MultimediaContent multimediaContent = null;

            if(multimediaContentId == null)
            {
                response.sendRedirect("multimediaContent");
                return;
            }

            multimediaEJB.deleteMultimediaContent(  token, Long.parseLong( multimediaContentId));


            request.getRequestDispatcher("multimediaContent").forward(request, response);

        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("multimediaContent");
        }
    }
}
