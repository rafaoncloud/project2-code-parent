<%@ page import="java.util.List" %>
<%@ page import="dto.Country" %>
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
          <h1 class="my-4">Edit Account</h1>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

           <div class="row">
            <div class="col-lg-8">
                 <br />
                 <br />
                 <br />
                <form id="Edit" name="Edit" method="post" action="${contextRoot}/account/edit">
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"  value='<%=request.getAttribute("name")%>' placeholder="Your Name" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="email" id="email" value='<%=request.getAttribute("email")%>' placeholder="Your Email" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="pwd" class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"   value='<%=request.getAttribute("password")%>' placeholder="Your Password" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phoneNumber" class="cols-sm-2 control-label required">Phone Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-phone-square" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"  value='<%=request.getAttribute("phoneNumber")%>'  placeholder="Your Phone Number" required/>
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

                                    <option  value= <%= c.getCountryId() %>  <%= (String.valueOf(c.getCountryId()).equals(String.valueOf(request.getAttribute("countryId")))) ? " selected ":"" %> >
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
                                <input type="text" class="form-control" name="address" id="address" value='<%=request.getAttribute("address")%>'  placeholder="Your Address" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="birthDate" class="cols-sm-2 control-label required">Brith Date</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                <input type="date" class="form-control" name="birthDate" id="birthDate" value='<%=request.getAttribute("birthDate")%>'  placeholder="Your Brith Date" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="crediCardNumber" class="cols-sm-2 control-label required">Credi Card Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                                <input type="number" class="form-control" name="crediCardNumber" id="crediCardNumber"  value='<%=request.getAttribute("crediCardNumber")%>' placeholder="Your Credi Card Number" required/>
                            </div>
                        </div>
                    </div>

                   <div class="form-group">
                        <label for="hasSubscriptionUpToDate" class="cols-sm-2 control-label required">Has Subscription</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="	fa fa-check" aria-hidden="true"></i></span>
                                <input type="checkbox" disabled="disabled" class="form-control" name="hasSubscriptionUpToDate" id="hasSubscriptionUpToDate"  <%=request.getAttribute("hasSubscriptionUpToDate")%> placeholder="Has Subscription Up To Date"/>
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
    <script type="text/javascript" src="javascript/script.js" charset="ISO-8859-1"></script>
  </body>
</html>

