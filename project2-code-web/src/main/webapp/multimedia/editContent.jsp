<%@ page import="java.util.List" %>
<%@ page import="dto.MultimediaContentCategory" %>
<%@ page import="utils.Utils" %>
<%@ page import="notifications.Message" %>
<%@ page import="notifications.NotificationsManager" %>
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

    <title>Webflix - Edit Mutlimedia Content</title>

    <link href="../css/toastr.min.css" rel="stylesheet"/>
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
          <h1 class="my-4">Edit Multimedia</h1>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

           <div class="row">
            <div class="col-lg-8">
                 <br />
                 <br />
                 <br />
                <form id="editContent" name="editContent" method="post" action="${contextRoot}/multimedia/editContent">
                    <input type="hidden" name="id" value="<%= request.getParameter("id")%>"/>
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Title</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="title" id="title"  value='<%=request.getAttribute("title")%>' placeholder="Title" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Director Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="directorName" id="directorName" value='<%=request.getAttribute("directorName")%>' placeholder="Director Name" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="crediCardNumber" class="cols-sm-2 control-label required">Year Of Release</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                                <input type="number"  min="1000" max="2019" class="form-control" name="yearOfRelease" id="yearOfRelease"  value='<%=request.getAttribute("yearOfRelease")%>' placeholder="Year Of Release" required/>
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
                                    <option  value= <%= c.getId() %>  <%= (String.valueOf(c.getId()).equals(String.valueOf(request.getAttribute("categoryId")))) ? " selected ":"" %> >
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
                        <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Save</button>
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
    <script type="text/javascript" src="../javascript/script.js" charset="ISO-8859-1"></script>
   <script src="../js/toastr.min.js"></script>
       <script type="application/javascript">
                $(function()
                {
                    toastr.options = {
                        "closeButton": false,
                        "debug": false,
                        "newestOnTop": false,
                        "progressBar": false,
                        "positionClass": "toast-bottom-right",
                        "preventDuplicates": false,
                        "onclick": null,
                        "showDuration": "300",
                        "hideDuration": "1000",
                        "timeOut": "5000",
                        "extendedTimeOut": "1000",
                        "showEasing": "swing",
                        "hideEasing": "linear",
                        "showMethod": "fadeIn",
                        "hideMethod": "fadeOut"
                    };

                    <%
                    String userId = request.getSession().getId();

                    if (userId != null)
                    {
                        while (true)
                        {
                            Message m = NotificationsManager.pollMessage(userId);

                            if (m == null)
                                break;

                            if (m.getType() == Message.Type.Success)
                            {%>
                                toastr.success("<%= m.getMessage()%>", "");
                            <%}
                            else if (m.getType() == Message.Type.Error)
                            {%>
                                toastr.error("<%= m.getMessage()%>", "");
                            <%}
                        }
                    }%>
                });
            </script>
  </body>
</html>
