package servlet.Account;

import ejb.UserEJB;
import dto.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet
{

    @Inject
    UserEJB urserEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            String email = request.getParameter("username");
            String password = request.getParameter("password");

            User user = urserEJB.login( email, password );

            request.getSession().setAttribute("token", user.getToken());
            request.getSession().setAttribute("id", user.getId());
            request.getSession().setAttribute("name", user.getName());
        }
        catch (Exception e)
        {

        }

        response.sendRedirect("index.jsp");

    }

}
