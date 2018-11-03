<%--
  Created by IntelliJ IDEA.
  User: rafa
  Date: 03/11/2018
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Template" pageEncoding="UTF-8" %>

<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true" %>
<!--%@attribute name="body_area" fragment="true" %-->

<!DOCTYPE html >
<html>

<head>
    <jsp:invoke fragment="head_area"/>
</head>

<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Webflix</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/register">Register</a>
                </li>

                <%
                    if (session.getAttribute("id") != null) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/edit">Edit Account</a>
                </li>

                <li class="nav-item">
                    <label class="nav-link">
                        &nbsp; &nbsp; <%= session.getAttribute("name") %>
                    </label>
                </li>
                <%
                } else {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </li>
                <%
                    }
                %>

            </ul>
        </div>
    </div>
</nav>

<!--jsp:invoke fragment="body_area"/-->
<jsp:doBody/>

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">© 2018 António Fernandes & Rafael Henriques, Enterprise Application
            Integration, DEI-FCTUC</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="bootstrap/jquery/jquery.min.js"></script>
<script src="bootstrap/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="javascript/script.js" charset="ISO-8859-1"></script>

</body>
</html>
