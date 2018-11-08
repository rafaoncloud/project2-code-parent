<%@ page import="utils.Utils" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/index.jsp">Webflix</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${contextRoot}/index.jsp">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <%
                    if (session.getAttribute("id") != null) {
                %>

                <%if (session.getAttribute("userType") == utils.Utils.UserType.Manager) {%>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/multimedia/addContent">Add New Multimedia</a>
                </li>
                <%
                    }
                %>

                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/multimedia/multimediaContent">Multimedia Content</a>
                </li>

                <%if (session.getAttribute("userType") == Utils.UserType.User) {%>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/watchlist/watchListContent">Watch List</a>
                </li>
                <%
                    }
                %>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navdrop" role="button" data-toggle="dropdown"
                       data-hover="dropdown"><%= session.getAttribute("name") %>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navdrop">
                        <form id="logoutForm" method="post" name="logoutForm" action="${contextRoot}/account/logout">
                            <button type="submit" class="dropdown-item">Logout</button>
                        </form>
                        <a href="${contextRoot}/account/edit" class="dropdown-item">Edit Account</a>
                        <form id="deleteForm" method="post" name="deleteForm" action="${contextRoot}/account/delete">
                            <button type="submit" class="dropdown-item">Delete Account</button>
                        </form>
                    </div>
                </li>
                <%
                } else {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/account/register">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/account/login.jsp">Login</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>