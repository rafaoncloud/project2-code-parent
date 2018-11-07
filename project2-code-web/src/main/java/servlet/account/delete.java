package servlet.account;

import ejb.UserEJB;
import notifications.NotificationsManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account/delete")
public class delete extends HttpServlet
{

    @Inject
    UserEJB urserEJB;

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            if (request.getSession().getAttribute("id") == null)
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            String token =  request.getSession().getAttribute("token").toString();
            urserEJB.deleteUser(token,Long.parseLong(request.getSession().getAttribute("id").toString() ) );

            request.getSession().invalidate();
            response.sendRedirect("../index.jsp");
        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
        }

        response.sendRedirect("../index.jsp");
    }
}
