<%@ page import="java.util.List" %>
<%@ page import="dto.Country" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home - Webflix</title>

    <!-- Bootstrap core CSS -->
    <link href="../bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/Index.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="../Index.jsp">Webflix</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="../Index.jsp">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../Account/Register">Register</a>
            </li>

          <%
          if (session.getAttribute("id") != null)
          {
           %>
              <li class="nav-item">
                     <a class="nav-link" href="Account/Edit">Edit Account</a>
              </li>

              <li class="nav-item">
                  <label class="nav-link">
                       &nbsp;  &nbsp; <%= session.getAttribute("name") %>
                  </label>
              </li>
          <%
          }

          else
          {
          %>
              <li class="nav-item">
                  <a class="nav-link" href="Account/Login">Login</a>
              </li>
           <%
          }
       %>

          </ul>
        </div>
      </div>
    </nav>

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
                <form id="RegisterForm" name="RegisterForm" method="post" action="Register">
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"  placeholder="Your Name"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="email" id="email"  placeholder="Your Email"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="pwd" class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"  placeholder="Your Password"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phoneNumber" class="cols-sm-2 control-label required">Phone Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-phone-square aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"  placeholder="Your Phone Number"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="country" class="cols-sm-2 control-label">Country</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-map-marker fa-lg" aria-hidden="true"></i></span>
                                <select class="form-control" name="country" id="country"  placeholder="Please select your Country">
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
                                <input type="text" class="form-control" name="address" id="address"  placeholder="Your Address"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="brithDate" class="cols-sm-2 control-label required">Brith Date</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-calendar aria-hidden="true"></i></span>
                                <input type="date" class="form-control" name="brithDate" id="brithDate"  placeholder="Your Brith Date"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="crediCardNumber" class="cols-sm-2 control-label required">Credi Card Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-credit-card-alt aria-hidden="true"></i></span>
                                <input type="number " class="form-control" name="crediCardNumber" id="crediCardNumber"  placeholder="Your Credi Card Number"/>
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

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">© 2018 António Fernandes & Rafael Henriques, Enterprise Application Integration, DEI-FCTUC</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="../bootstrap/jquery/jquery.min.js"></script>
    <script src="../bootstrap/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="javascript/script.js" charset="ISO-8859-1"></script>
  </body>

</html>
