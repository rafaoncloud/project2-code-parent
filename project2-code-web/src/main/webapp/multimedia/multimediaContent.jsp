<%@ page import="java.util.List" %>
<%@ page import="dto.MultimediaContentCategory" %>
<%@ page import="dto.MultimediaContent" %>
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
    <link href="../bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/index.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <%@include file="../shared/navbar.jsp"%>

 <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3">


          <h1 class="my-4">Categories</h1>
          <div class="list-group">
            <%
            for (MultimediaContentCategory c : (List<MultimediaContentCategory>)request.getAttribute("categories"))
            {
            %>
                <a href="?categoryId=<%= c.getId() %>" class="list-group-item"> <%= c.getCategory() %></a>
            <%
            }
            %>
          </div>

          <h1 class="my-4">Yar</h1>
          <div class="list-group">
            <input type="number" class="form-control" name="minYear" id="minYear"  placeholder="Min Year"/>
            <input type="number" class="form-control" name="maxYear" id="maxYear"  placeholder="Max Year"/>
          </div>

          <h1 class="my-4">Title</h1>
               <div class="list-group">
                 <input type="text" class="form-control" name="title" id="title"  placeholder="Title"/>
               </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <div class="row">


            <%
            for (MultimediaContent mc : (List<MultimediaContent>)request.getAttribute("lstMultimediaContent"))
            {
            %>
                <div class="col-lg-4 col-md-6 mb-4">
                  <div class="card h-100">
                    <a href="../multimedia/showMultimediaContent?id=<%= mc.getId() %>"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                    <div class="card-body">
                      <h4 class="card-title">
                        <a href="../multimedia/showMultimediaContent?id=<%= mc.getId() %>"><%= mc.getTitle() %></a>
                      </h4>
                      <h5><%= mc.getDirectorName() %></h5>
                      <p class="card-text"><%= mc.getYearOfRelease() %></p>
                      <p class="card-text"><%= mc.getCategory().getCategory() %></p>
                    </div>
                    <div class="card-footer">
                      <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                    </div>
                  </div>
                </div>

            <%
            }
            %>

          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
   <%@include file="../shared/footer.jsp"%>


    <!-- Bootstrap core JavaScript -->
    <script src="../bootstrap/jquery/jquery.min.js"></script>
    <script src="../bootstrap/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="javascript/script.js" charset="ISO-8859-1"></script>
  </body>
</html>
