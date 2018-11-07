package servlet.account;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/account/edit")
public class Edit extends HttpServlet
{
    @Inject
    CountryEJB countryEJB;

    @Inject
    UserEJB urserEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            if (request.getSession().getAttribute("id") == null)
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            if (request.getSession().getAttribute("id") == null || request.getSession().getAttribute("token") == null)
            {
                response.sendRedirect("../index.jsp");
                return;
            }

            long userId = Long.parseLong(request.getSession().getAttribute("id").toString());
            String token =  request.getSession().getAttribute("token").toString();

            List<Country> countries  = countryEJB.getAllCountries( token ,false);
            request.setAttribute("Countries",countries);

            var user = urserEJB.getUser(token, userId);

            request.setAttribute("name",user.getName());
            request.setAttribute("email",user.getEmail());
            request.setAttribute("password",user.getPassword());
            request.setAttribute("address",user.getAddress());
            request.setAttribute("phoneNumber", user.getPhoneNumber());
            request.setAttribute("crediCardNumber", user.getCreditCardNumber());
            request.setAttribute("birthDate", new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthDate()));
            if (request.getSession().getAttribute("userType").equals( Utils.UserType.Manager))
                request.setAttribute("hasSubscriptionUpToDate", user.getHasSubscriptionUpToDate() == true ? "checked" :  "");
            request.getSession().setAttribute("hasSubscriptionUpToDate", user.getHasSubscriptionUpToDate());


            if(user.getCountry() != null)
                request.setAttribute("countryId", user.getCountry().getCountryId() );


            request.getRequestDispatcher("edit.jsp").forward(request, response);

        }
        catch (Exception e)
        {
            response.sendRedirect("../index.jsp");
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

            long userId = Long.parseLong(request.getSession().getAttribute("id").toString());
            String token =  request.getSession().getAttribute("token").toString();

            User user = new User();

            user.setId(userId);
            user.setName( request.getParameter("name"));
            user.setEmail( request.getParameter("email"));
            user.setPassword( request.getParameter("password"));
            user.setAddress( request.getParameter("address"));
            user.setBirthDate( Utils.ParseDate(  request.getParameter("birthDate") ));
            user.setHasSubscriptionUpToDate(Boolean.parseBoolean(request.getSession().getAttribute("hasSubscriptionUpToDate").toString()));


            if(request.getParameter("phoneNumber").length() > 0)
                user.setPhoneNumber( request.getParameter("phoneNumber"));

            user.setCreditCardNumber( request.getParameter("crediCardNumber"));

            if(request.getParameter("country") != null && Utils.isNumeric(request.getParameter("country")))
            {
                Country country = countryEJB.getCountry( "", Long.parseLong(request.getParameter( "country" ) ));
                user.setCountry( country );
            }

            urserEJB.updateUser(token, user);

        }
        catch (Exception e)
        {
            response.sendRedirect("../index.jsp");
        }

        response.sendRedirect("../index.jsp");
    }

}
