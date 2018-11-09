<%@ page import="java.util.List" %>
<%@ page import="dto.Country" %>
<%@ page import="utils.Utils" %>
<%@ page import="notifications.Message" %>
<%@ page import="notifications.NotificationsManager" %>
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

    <title>Webflix - Register</title>

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
          <h1 class="my-4">Register</h1>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

           <div class="row">
            <div class="col-lg-8">
                 <br />
                 <br />
                 <br />
                <form id="RegisterForm" name="RegisterForm" method="post" action="${contextRoot}/account/register">
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"  placeholder="Your Name" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="email" id="email"  placeholder="Your Email" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="pwd" class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"  placeholder="Your Password" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phoneNumber" class="cols-sm-2 control-label required">Phone Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-phone-square" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"  placeholder="Your Phone Number" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="country" class="cols-sm-2 control-label">Country</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-map-marker fa-lg" aria-hidden="true"></i></span>
                                <select class="form-control" name="country" id="country"  placeholder="Please select your Country" required>
                                <option>-select-</option>
                                <%
                                for (Country c : (List<Country>)request.getAttribute("Countries"))
                                {
                                %>
                                    <option  value= <%= c.getCountryId() %> >
                                    <%= c.getCountryName() %>
                                    </option>
                                    <%
                                }
                                %>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="address" class="cols-sm-2 control-label required">Address</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="address" id="address"  placeholder="Your Address" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="brithDate" class="cols-sm-2 control-label required">Brith Date</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                <input type="date" class="form-control" name="brithDate" id="brithDate"  placeholder="Your Brith Date" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="creditCardNumber" class="cols-sm-2 control-label required">Credit Card Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                                <input type="number " class="form-control" name="creditCardNumber" id="creditCardNumber"  placeholder="Your Credit Card Number" required/>
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
