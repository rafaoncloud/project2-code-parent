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
    <link href="../css/login.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <%@include file="../shared/navbar.jsp"%>

    <!-- Page Content -->
    <div class="container">
        <div class="omb_login">
            <br /><br /><br /><br /><br /><br /><br /><br />
            <h3 class="omb_authTitle">Webflix</h3>
            <div class="row omb_row-sm-offset-3">
                <div class="col-xs-12 col-sm-6">
                      <form class="omb_loginForm"  id="Login" name="Login" method="POST" action="${contextRoot}/account/login">
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
                        <button class="btn btn-primary btn-block" type="submit">Login<i class="fa fa-sign-in"></i></button>
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

    <!-- Bootstrap core JavaScript -->
    <script src="../bootstrap/jquery/jquery.min.js"></script>
    <script src="../bootstrap/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="javascript/script.js" charset="ISO-8859-1"></script>
  </body>
</html>
