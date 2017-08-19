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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript"> <%@include file="js/functional.js"%> </script>

</head>
<body onload="RestGet()" >
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

            <table class="table table-striped">
                <thead>
                <tr class="active">
                    <th>id</th>
                    <th>Name</th>
                    <th>Last name</th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="table" style="background: #ccc">

                </tbody>

            </table>


        </div>

    </div>
</body>
</html>
