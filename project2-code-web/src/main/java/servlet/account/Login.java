package servlet.account;

import dto.GenericUser;
import dto.Manager;
import ejb.GenericUserEJB;
import dto.User;
import ejb.UserEJB;
import notifications.NotificationsManager;
import utils.Utils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account/login")
public class Login extends HttpServlet
{
    @Inject
    GenericUserEJB genericUserEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String email = request.getParameter("username");
            String password = request.getParameter("password");

            GenericUser user = genericUserEJB.login( email, password);

            Utils.UserType type = null;

            if (user instanceof Manager)
                type = Utils.UserType.Manager;
            else if (user instanceof User)
                type = Utils.UserType.User;

            request.getSession().setAttribute("token", user.getToken());
            request.getSession().setAttribute("id", user.getId());
            request.getSession().setAttribute("name", user.getName());
            request.getSession().setAttribute("userType", type);
        }
        catch (Exception e)
        {
            NotificationsManager.addErrorMessage(request.getSession().getId(), e.getMessage());
        }

        response.sendRedirect("../index.jsp");
    }
    
}
