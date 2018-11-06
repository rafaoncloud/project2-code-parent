<%@ page import="java.util.List" %>
<%@ page import="dto.MultimediaContentCategory" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%if (session.getAttribute("id") == null || session.getAttribute("userType") != utils.Utils.UserType.Manager)
    response.sendRedirect("../index.jsp");%>


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
          <h1 class="my-4">Add Multimedia</h1>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

           <div class="row">
            <div class="col-lg-8">
                 <br />
                 <br />
                 <br />
                <form id="AddContentForm" name="AddContentForm" method="post" action="${contextRoot}/multimedia/addContent">
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Title</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="title" id="title"  placeholder="Title" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Director Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="directorName" id="directorName"  placeholder="Director Name" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="crediCardNumber" class="cols-sm-2 control-label required">Year Of Release</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                                <input type="number"  min="1000" max="2019" class="form-control" name="yearOfRelease" id="yearOfRelease"  placeholder="Year Of Release" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="crediCardNumber" class="cols-sm-2 control-label required">File</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                                 <input required  accept="video/*" type="file" class="form-control" name="file" id="file">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="country" class="cols-sm-2 control-label">Category</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-map-marker fa-lg" aria-hidden="true"></i></span>
                                <select class="form-control" name="category" id="category"  placeholder="Please select category" required>
                                <option>-select-</option>
                                <%
                                for (MultimediaContentCategory c : (List<MultimediaContentCategory>)request.getAttribute("categories"))
                                {
                                %>
                                    <option  value= <%= c.getId() %> >
                                    <%= c.getCategory() %>
                                    </option>
                                    <%
                                }
                                %>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group ">
                        <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Submit</button>
                    </div>
                </form>
                <br />
                </div>
            </div>

          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->
        <br />
        <br />
        <br />
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
