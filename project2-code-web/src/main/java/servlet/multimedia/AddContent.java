package servlet.multimedia;

import dto.Country;
import dto.MultimediaContent;
import dto.MultimediaContentCategory;
import ejb.MultimediaContentCategoryEJB;
import ejb.MultimediaContentEJB;
import notifications.NotificationsManager;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileItemFactory;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.Utils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet("/multimedia/addContent")
public class AddContent extends HttpServlet
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

            request.getRequestDispatcher("addContent.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("addContent.jsp");
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
            if (request.getSession().getAttribute("id") == null || !request.getSession().getAttribute("userType").equals( Utils.UserType.Manager))
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

                String title = request.getParameter("title");
                int yarOgRelease =  Integer.parseInt(request.getParameter("yearOfRelease"));
                String derectorName = request.getParameter("directorName");
                long categoryId = Long.parseLong(request.getParameter( "category" ));


                MultimediaContentCategory category = categoryEJB.getMultimediaContentCategory((String) request.getSession().getAttribute("token"), categoryId);

                MultimediaContent multimediaContent = new MultimediaContent(filePath,title,category,yarOgRelease,derectorName,new Date());

                multimediaEJB.addMultimediaContent((String)request.getSession().getAttribute("token"), multimediaContent);

                NotificationsManager.addSuccessMessage(request.getSession().getId(), "Multimedia Content created successfully.");
            //}


            response.sendRedirect("multimediaContent");
        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
            response.sendRedirect("../index.jsp");
        }
    }


}
