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
            if (request.getSession().getAttribute("id") == null)
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
                response.sendRedirect("multimediaContent");
                return;
            }

            dto.MultimediaContent multimediaContent = multimediaEJB.getMultimediaContent(  token, Long.parseLong( multimediaContentId));

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
        String name = null;
        //String categoryId = null;
        String filePath = null;
        long fileSize = 0;

        try
        {
            if (request.getSession().getAttribute("id") == null)
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            if (request.getSession().getAttribute("id") == null || !request.getSession().getAttribute("userType").equals( Utils.UserType.Manager))
            {
                response.sendRedirect("../index.jsp");
                return;
            }

//            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//
//            if (isMultipart)
//            {
//                FileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//
//                ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
//
//                List items = servletFileUpload.parseRequest(request);
//
//                Iterator iterator = items.iterator();
//
//                while (iterator.hasNext())
//                {
//                    FileItem item = (FileItem) iterator.next();
//
//                    if (!item.isFormField())
//                    {
//                        String fileName = item.getName();
//
//                        String rootPath = getServletContext().getRealPath("/");
//
//                        File completePath = new File(rootPath + "/multimedia/" + categoryId);
//
//                        if (!completePath.exists())
//                            completePath.mkdirs();
//
//                        File newFile = new File(completePath + "/" + fileName);
//
//                        filePath = "multimedia/" + categoryId + "/" + fileName;
//                        fileSize = item.getSize();
//
//                        item.write(newFile);
//                    }
//                    else
//                    {
//                        if (item.getFieldName().equals("courseID"))
//                            categoryId = new String(item.get());
//                        else if (item.getFieldName().equals("name"))
//                            name = new String(item.get());
//                    }
//                }

            dto.MultimediaContent multimediaContent = new MultimediaContent();

            multimediaContent.setTitle( request.getParameter("title"));
            multimediaContent.setYearOfRelease( Integer.parseInt(request.getParameter("yearOfRelease")));
            multimediaContent.setDirectorName( request.getParameter("directorName"));

            long categoryId = Long.parseLong(request.getParameter( "category" ));

            MultimediaContentCategory category = categoryEJB.getMultimediaContentCategory((String) request.getSession().getAttribute("token"), categoryId);

            multimediaContent.setCategory(category );

            multimediaEJB.updateMultimediaContent((String)request.getSession().getAttribute("token"), multimediaContent);

            NotificationsManager.addSuccessMessage(request.getSession().getId(), "Multimedia Content updated successfully.");
            //}


            response.sendRedirect("multimediaContent?categoryId=" + categoryId);
        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("../index.jsp");
        }
    }

}

