package servlet.watchlist;

import ejb.WatchListEJB;
import utils.Utils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/watchlist/delete")
public class deleteFromWatchList extends HttpServlet {

    @Inject
    WatchListEJB watchListEJB;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            if (request.getSession().getAttribute("id") == null || !request.getSession().getAttribute("userType").equals(Utils.UserType.User)) {
                response.sendRedirect("../index.jsp");
                return;
            }

            String token = request.getSession().getAttribute("token").toString();
            Long multimediaContentId = Long.parseLong(request.getParameter("dMContentId"));
            Long userId = Long.parseLong(request.getSession().getAttribute("id").toString());

            if(multimediaContentId == null){
                response.sendRedirect("watchListContent");
                return;
            }

            watchListEJB.removeContentFromWatchList(token,multimediaContentId,userId);

            response.sendRedirect("watchListContent");
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("watchListContent");
        }


    }
}
