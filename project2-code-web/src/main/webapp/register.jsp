<%@ page import="dto.Country" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="contriesChooseRegister">
    <% for (Country c : (List<Country>) request.getAttribute("Countries")) { %>
    <option value=<%= c.getCountryId() %>>
        <%= c.getCountryName() %>
    </option>
    <% } %>
</c:set>

<mt:layout title="Register - Webflix">


    <jsp:attribute name="head_area">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home - Webflix</title>
        <!-- Bootstrap core CSS -->
        <link href="bootstrap/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/Index.css" rel="stylesheet">
</jsp:attribute>

<jsp:body>
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
                    <br/>
                    <br/>
                    <br/>
                    <form id="RegisterForm" name="RegisterForm" method="post" action="register">
                        <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label">Name</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa"
                                                                       aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="name" id="name"
                                           placeholder="Your Name"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Email</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="email" id="email"
                                           placeholder="Your Email"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Password</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="password" id="password"
                                           placeholder="Your Password"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phoneNumber" class="cols-sm-2 control-label required">Phone Number</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-phone-square"
                                                                       aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"
                                           placeholder="Your Phone Number"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="country" class="cols-sm-2 control-label">Country</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-map-marker fa-lg"
                                                                       aria-hidden="true"></i></span>
                                    <select class="form-control" name="country" id="country"
                                            placeholder="Please select your Country">
                                        <option>-select-</option>
                                            ${contriesChooseRegister}
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="address" class="cols-sm-2 control-label required">Address</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-address-card"
                                                                       aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="address" id="address"
                                           placeholder="Your Address"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="brithDate" class="cols-sm-2 control-label required">Brith Date</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-calendar "
                                                                       aria-hidden="true"></i></span>
                                    <input type="date" class="form-control" name="brithDate" id="brithDate"
                                           placeholder="Your Brith Date"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="crediCardNumber" class="cols-sm-2 control-label required">Credi Card
                                Number</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-credit-card-alt"
                                                                       aria-hidden="true"></i></span>
                                    <input type="number " class="form-control" name="crediCardNumber"
                                           id="crediCardNumber" placeholder="Your Credi Card Number"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group ">
                            <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Submit</button>
                        </div>
                    </form>
                    <br/>
                </div>
            </div>

        </div>
        <!-- /.row -->

    </div>
    <!-- /.col-lg-9 -->

</div>
<!-- /.row -->
</jsp:body>
</mt:layout>
