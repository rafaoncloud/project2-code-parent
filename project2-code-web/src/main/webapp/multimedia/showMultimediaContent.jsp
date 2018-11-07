<%@ page import="dto.MultimediaContentCategory" %>
<%@ page import="dto.MultimediaContent" %>
<%@ page import="utils.Utils" %>
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
            <%
            MultimediaContent multimediaContent = (MultimediaContent)request.getAttribute("multimediaContent");
            %>

          <h1 class="my-4">Multimedia Content</h1>

        </div>
        <!-- /.col-lg-3 -->

                <div class="col-lg-9">
                  <div class="card h-100">
                    <img class="card-img-top" src="http://placehold.it/700x400" alt="">
                    <div class="card-body">
                      <h4 class="card-title"> <%= multimediaContent.getTitle() %></h4>
                      <h5><%= multimediaContent.getDirectorName() %></h5>
                      <p class="card-text"><%= multimediaContent.getYearOfRelease() %></p>
                      <p class="card-text"><%= multimediaContent.getCategory().getCategory() %></p>

                    </div>
                    <div class="card-footer">

                      <div class="row">
                       <div class="col-lg-6">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                        <div class="col-lg-4"></div>

  <%
                               if(session.getAttribute("userType") == utils.Utils.UserType.Manager)
                                {
                                %>
                          <div class="col-lg-1">
                            <form id="deleteContent" method="post" name="deleteContent" action="${contextRoot}/multimedia/deleteContent">
                              <button style="margin-left: -10px;"  type="submit" class="btn btn-danger">Delete</button>
                              <input type="hidden" name="dMContentId" value="<%= multimediaContent.getId() %>"/>
                            </form>
                           </div>
                           <div class="col-lg-1">
                                <a href="${contextRoot}/multimedia/editContent?id=<%= multimediaContent.getId() %>" class="btn btn-secondary">Edit</a>
                           </div>
        <%
                                }
                                %>

                      </div>
                    </div>
                  </div>

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
