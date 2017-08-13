
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
        <%@include file="js/butt.js"%>
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

    <h3>User: </h3>
    <form>
        <div class="row">
            <div class="col-xs-5">
                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="First Name">
            </div>
            <br/><br/><br/>
            <div class="col-xs-5">
                 <input type="text"  class="form-control" id="password" placeholder="Second Name" >
            </div>
            <br/><br/><br/>
            <div>
                <button type="button" class="btn btn-default" onclick="RestAdd()"><span class ="glyphicon glyphicon-ok"></span> Add</button>
            </div>
            <br/>
            <button type="reset" class="btn btn-danger" onclick="RestDelete()"><span class="glyphicon glyphicon-remove"></span>Del</button>
            <div class="col-xs-2">
                <input type="text" class="form-control" id="id" placeholder="id for deleted">
            </div>
        </div>
    </form>
    <br/><br/>
<div class="jumbotron">
    <div>
        <button type="submit" class="btn btn-primary" onclick="RestGet()"></span>Get List</button>
        <div id="table" >
        </div>
    </div>

</div>
</div>

</body>
</html>
