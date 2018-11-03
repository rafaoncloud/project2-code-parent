<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>


<html lang="en">

<mt:layout title="Register - Webflix">

<jsp:attribute name="head_area">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Register - Webflix</title>
    <!-- Bootstrap core CSS -->
    <link href="bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/Login.css" rel="stylesheet">
</jsp:attribute>

<jsp:body>
<!-- Page Content -->
<div class="container">
    <div class="omb_login">
        <br/><br/><br/><br/><br/><br/><br/><br/>
        <h3 class="omb_authTitle">Login</h3>
        <div class="row omb_row-sm-offset-3">
            <div class="col-xs-12 col-sm-6">
                <form class="omb_loginForm" id="Login" name="Login" method="POST" action="login">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input type="text" class="form-control" name="username" id="username"
                               placeholder="email address">
                    </div>
                    <span class="help-block"></span>

                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                    <span class="help-block">Password error</span>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Login<i class="fa fa-sign-in"></i>
                    </button>
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
</jsp:body>
</mt:layout>
