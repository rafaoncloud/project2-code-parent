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

            List<dto.MultimediaContent> multimediaContent =  null;
            if(request.getParameter("categoryId") != null){
                multimediaContent = multimediaEJB.getMultimediaContentFromCategory(token,Long.parseLong(request.getParameter("categoryId")),true);
            }else if(request.getParameter("minYear") != null && request.getParameter("maxYear") != null) {
                multimediaContent = multimediaEJB.getMultimediaContentBetweenYearsRange(token,
                        Integer.parseInt(request.getParameter("minYear")),
                                Integer.parseInt(request.getParameter("maxYear")),true);
            }else if(request.getParameter("directorName") != null){
                multimediaContent = multimediaEJB.getMultimediaContentFromDirector(token,request.getParameter("directorName"),true);
            }else{
                multimediaContent = multimediaEJB.getTopMultimediaContent(  token,10,false);

            }
            request.setAttribute("lstMultimediaContent",multimediaContent);
            request.getRequestDispatcher("multimediaContent.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("multimediaContent");
        }
    }

}
