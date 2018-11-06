<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Webflix - ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/index.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <%@include file="./shared/navbar.jsp"%>


        <%@include file="home.jsp"%>







    <!-- Footer -->
   <%@include file="./shared/footer.jsp"%>


    <!-- Bootstrap core JavaScript -->
    <script src="bootstrap/jquery/jquery.min.js"></script>
    <script src="bootstrap/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="javascript/script.js" charset="ISO-8859-1"></script>
  </body>
</html>
