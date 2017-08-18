<!--
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
-->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript">
        <%@include file="js/functional.js"%>
    </script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
           <div class="navbar-header">
            <a class="navbar-brand" href="https://www.epolsoft.com/ru/home_ru/" title="www.epolsoft.com">Epol Soft</a>
            </div>
        </div>
    </nav>
<div class="container">

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <h3>Admin: </h3>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <h3>User: </h3>
    </sec:authorize>

    <form>
        <div class="row">
            <div class="col-xs-5">
                <input type="text" class="form-control" id="exampleInputName" placeholder="Name">
            </div>
            <div class="col-xs-5">
                 <input type="text" class="form-control" id="exampleInputLastName" placeholder="Last name">
            </div>
        </div>
        <br>
        <button type="button" class="btn btn-default" onclick="RestAdd()"><span class ="glyphicon glyphicon-ok"></span> Add</button>
        <br>
    </form>
    <br>
    <div class="jumbotron row">
        <button type="submit" class="btn btn-primary" onclick="RestGet()"></span>Get List</button>
        <div class="row">
            <div class="col-xs-2">
            <br>
                <input type="text" class="form-control" id="id" placeholder="id for deleted">
            </div>
            <br>
                <button type="reset" class="btn btn-danger" onclick="RestDelete()"><span class="glyphicon glyphicon-remove"></span>Del</button>
        </div>
        <br>

        <table class="table table-striped">
            <thead>
                <tr class="active">
                    <th>id</th>
                    <th>Name</th>
                    <th>Last name</th>
                </tr>
            </thead>
            <tbody id="table" style="background: #ccc">

            </tbody>

        </table>


    </div>   

</div>
</body>
</html>
