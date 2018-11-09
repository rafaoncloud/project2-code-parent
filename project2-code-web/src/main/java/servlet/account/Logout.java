package servlet.account;

import ejb.GenericUserEJB;
import ejb.UserEJB;
import notifications.NotificationsManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account/logout")
public class Logout  extends HttpServlet
{
    @Inject
    GenericUserEJB genericUserEJB;

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
            genericUserEJB.logout(token);

            NotificationsManager.addSuccessMessage(request.getSession().getId(), "End of session.");
            request.getSession().invalidate();

        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
        }

        response.sendRedirect("../index.jsp");
    }
}
