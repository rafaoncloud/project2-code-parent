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
    <link href="../css/Login.css" rel="stylesheet">

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
<div class="omb_login">
<br /><br /><br /><br /><br /><br /><br /><br />
    	<h3 class="omb_authTitle">Login</h3>
		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-6">
			      <form class="omb_loginForm"  id="Login" name="Login" method="POST" action="Login">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" class="form-control" name="username" id="username" placeholder="email address">
					</div>
					<span class="help-block"></span>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input  type="password" class="form-control" name="password" placeholder="Password">
					</div>
                    <span class="help-block">Password error</span>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login<i class="fa fa-sign-in"></i></button>
				</form>
			</div>
    	</div>
		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-3">
				<label class="checkbox">
					<input type="checkbox" value="remember-me">Remember Me
				</label>
			</div>
			<div class="col-xs-12 col-sm-3">
				<p class="omb_forgotPwd">
					<a href="#">Forgot password?</a>
				</p>
			</div>
		</div>
	</div>

    </div>
    <!-- /.container -->

    <!-- Footer
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">© 2018 António Fernandes & Rafael Henriques, Enterprise Application Integration, DEI-FCTUC</p>
      </div>
    </footer>-->

    <!-- Bootstrap core JavaScript -->
    <script src="../bootstrap/jquery/jquery.min.js"></script>
    <script src="../bootstrap/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="javascript/script.js" charset="ISO-8859-1"></script>
  </body>

</html>
