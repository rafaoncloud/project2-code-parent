package servlet.Account;

import dto.Country;
import dto.User;
import ejb.CountryEJB;
import ejb.UserEJB;
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


@WebServlet("/Account/Register")
public class Register extends HttpServlet
{
    @Inject
    CountryEJB countryEJB;

    @Inject
    UserEJB urserEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            List<Country> countries  = countryEJB.getAllCountries( "" ,false);
            request.setAttribute("Countries",countries);

            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            response.sendRedirect("Index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            User user = new User();

            user.setName( request.getParameter("name"));
            user.setEmail( request.getParameter("email"));
            user.setPassword( request.getParameter("password"));
            user.setAddress( request.getParameter("address"));
            user.setBirthDate( Utils.ParseDate(  request.getParameter("brithDate") ));

            if(request.getParameter("phoneNumber").length() > 0)
                user.setPhoneNumber( request.getParameter("phoneNumber"));

            user.setCreditCardNumber( request.getParameter("crediCardNumber"));
            user.setCreateDate( new Date() );

            if(request.getParameter("country") != null && Utils.isNumeric(request.getParameter("country")))
            {
                Country country = countryEJB.getCountry( "", Long.parseLong(request.getParameter( "country" ) ));
                user.setCountry( country );
            }
            urserEJB.addUser(user);

        }
        catch (Exception e)
        {
            response.sendRedirect("../Index.jsp");
        }

        response.sendRedirect("../Index.jsp");
    }


}
