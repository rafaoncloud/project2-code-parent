package servlet.Account;

import dto.Country;
import ejb.CountryEJB;
import ejb.UserEJB;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit")
public class Edit extends HttpServlet
{
    @Inject
    CountryEJB countryEJB;

    @Inject
    UserEJB urserEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            if (request.getSession().getAttribute("id") == null || request.getSession().getAttribute("token") == null)
            {
                response.sendRedirect("index.jsp");
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
            //request.setAttribute("address",user.getAddress());
            //request.setAttribute("phoneNumber", Long.parseLong(user.getPhoneNumber()));
            //request.setAttribute("crediCardNumber", Long.parseLong(user.getCreditCardNumber())  );

            if(user.getCountry() != null)
                request.setAttribute("CountryId", user.getCountry().getCountryId() );


            request.getRequestDispatcher("edit.jsp").forward(request, response);

        }
        catch (Exception e)
        {
            response.sendRedirect("index.jsp");
        }
    }

}
