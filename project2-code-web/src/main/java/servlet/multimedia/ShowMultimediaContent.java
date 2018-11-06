package servlet.multimedia;


import dto.MultimediaContent;
import dto.MultimediaContentCategory;
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


@WebServlet("/multimedia/showMultimediaContent")
public class ShowMultimediaContent extends HttpServlet
{

    @Inject
    MultimediaContentEJB multimediaEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            if (request.getSession().getAttribute("id") == null)
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            String token =  request.getSession().getAttribute("token").toString();


            String multimediaContentId = request.getParameter("id");


            dto.MultimediaContent multimediaContent = null;

            if(multimediaContentId != null)
                multimediaContent = multimediaEJB.getMultimediaContent(  token, Long.parseLong( multimediaContentId));
            else
                request.getRequestDispatcher("multimediaContent").forward(request, response);

            request.setAttribute("multimediaContent",multimediaContent);

            request.setAttribute("id",multimediaContentId);

            request.getRequestDispatcher("showMultimediaContent.jsp").forward(request, response);

        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("showMultimediaContent.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            if (request.getSession().getAttribute("id") == null)
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            String token =  request.getSession().getAttribute("token").toString();


            String multimediaContentId = request.getParameter("id");


            dto.MultimediaContent multimediaContent = null;

            if(multimediaContentId == null)
            {
                request.getRequestDispatcher("multimediaContent").forward(request, response);
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
