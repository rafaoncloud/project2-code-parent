<%@ page import="java.util.List" %>
<%@ page import="dto.MultimediaContentCategory" %>
<%@ page import="dto.MultimediaContent" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<%@include file="../shared/navbar.jsp" %>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">


            <h1 class="my-4">Categories</h1>
            <div class="list-group">
                <a href="../multimedia/multimediaContent"
                    class="list-group-item">ALL
                </a>
                <%
                    for (MultimediaContentCategory c : (List<MultimediaContentCategory>) request.getAttribute("categories")) {
                %>
                <a href="../multimedia/multimediaContent?categoryId=<%= c.getId() %>"
                   class="list-group-item"><%= c.getCategory() %>
                </a>
                <%
                    }
                %>
            </div>

            <h1 class="my-4">Years' Range</h1>
            <div class="list-group">
                <form id="searchByYear" method="GET" name="searchByYear"
                      action="${contextRoot}/multimedia/multimediaContent">
                    <input type="number" class="form-control" name="minYear" id="minYear" placeholder="Min Year"/>
                    <input type="number" class="form-control" name="maxYear" id="maxYear" placeholder="Max Year"/>
                    <button type="submit" class="btn btn-danger">Search</button>
                </form>
            </div>

            <h1 class="my-4">Director Name</h1>
                <div class="list-group">
                    <form id="searchByDirectorName" method="GET" name="searchByDirectorName"
                          action="${contextRoot}/multimedia/multimediaContent">
                        <input type="text" class="form-control" name="directorName" id="directorName" placeholder="Director Name"/>
                        <button type="submit" class="btn btn-danger">Search</button>
                    </form>
                </div>

                <h1 class="my-4">Title</h1>
                <div class="list-group">
                    <form id="searchByDirectorName" method="GET" name="searchByDirectorName"
                          action="${contextRoot}/multimedia/multimediaContent">
                        <input type="text" class="form-control" name="title" id="title" placeholder="Title"/>
                        <button type="submit" class="btn btn-danger">Search</button>
                    </form>
                </div>
                <br/><br/><br/><br/><br/>
                <br/><br/><br/><br/><br/>
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
                    for (MultimediaContent mc : (List<MultimediaContent>) request.getAttribute("lstMultimediaContent")) {
                %>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="../multimedia/showMultimediaContent?id=<%= mc.getId() %>"><img class="card-img-top"
                                                                                                src="http://placehold.it/700x400"
                                                                                                alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="../multimedia/showMultimediaContent?id=<%= mc.getId() %>"><%= mc.getTitle() %>
                                </a>
                            </h4>
                            <h5><%= mc.getDirectorName() %>
                            </h5>
                            <p class="card-text"><%= mc.getYearOfRelease() %>
                            </p>
                            <p class="card-text"><%= mc.getCategory().getCategory() %>
                            </p>
                            <%
                                if (session.getAttribute("userType") == Utils.UserType.User) {
                            %>
                            <div class="col-lg-1">
                                <form id="addToWatchList" method="POST" name="addToWatchList"
                                      action="${contextRoot}/watchlist/add">
                                    <button style="margin-left: -10px;" type="submit" class="btn btn-primary">Add to Watch List</button>
                                    <input type="hidden" name="dMContentId" value="<%= mc.getId() %>"/>
                                </form>
                            </div>
                            <%
                                }
                            %>
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
    <br/><br/><br/><br/><br/>
    <br/><br/><br/><br/><br/>
    <br/><br/><br/><br/><br/>
    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<%@include file="../shared/footer.jsp" %>


<!-- Bootstrap core JavaScript -->
<script src="../bootstrap/jquery/jquery.min.js"></script>
<script src="../bootstrap/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="javascript/script.js" charset="ISO-8859-1"></script>
</body>
</html>
