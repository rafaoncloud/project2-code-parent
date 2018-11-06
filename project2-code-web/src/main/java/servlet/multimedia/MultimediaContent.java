package servlet.multimedia;

import dto.MultimediaContentCategory;
import ejb.MultimediaContentCategoryEJB;
import ejb.MultimediaContentEJB;
import notifications.NotificationsManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/multimedia/multimediaContent")
public class MultimediaContent extends HttpServlet
{
    @Inject
    MultimediaContentCategoryEJB categoryEJB;


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

            List<MultimediaContentCategory> categories  = categoryEJB.getAllMultimediaContentCategory( token ,false);
            request.setAttribute("categories",categories);

            //String categoryId = request.getParameter("categoryId");

//            if(categoryId != null) {
//                multimediaContent = multimediaEJB.getMultimediaContentFromCategory( token, Long.parseLong( categoryId ), false );
//                categoryId = "?categoryId=" + categoryId;
//            }
//            else
//            {
            List<dto.MultimediaContent> multimediaContent = multimediaContent = multimediaEJB.getTopMultimediaContent(  token,6,false);


            request.setAttribute("lstMultimediaContent",multimediaContent);

            request.getRequestDispatcher("multimediaContent.jsp").forward(request, response);

        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("multimediaContent.jsp");
        }
    }

}
