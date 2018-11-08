package servlet.watchlist;

import ejb.WatchListEJB;
import servlet.multimedia.MultimediaContent;
import utils.Utils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/watchlist/watchListContent")
public class WatchList extends HttpServlet {

    @Inject
    WatchListEJB watchListEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if (request.getSession().getAttribute("id") == null || !request.getSession().getAttribute("userType").equals(Utils.UserType.User)) {
                response.sendRedirect("../index.jsp");
                return;
            }

            String token = request.getSession().getAttribute("token").toString();

            long userId = Long.parseLong(request.getSession().getAttribute("id").toString());

            List<dto.MultimediaContent> watchList = watchListEJB.getWatchList(token,userId);

            request.setAttribute("lstMultimediaContent",watchList);
            request.getRequestDispatcher("watchListContent.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("../index.jsp");
        }
    }
}
