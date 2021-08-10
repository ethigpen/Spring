<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Survey Result</title>
</head>
<body class="container">
    <h1 class="text-decoration-underline">Submitted Info</h1>
    <table class="table-borderless">
        <tr>
            <td>Name:</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>Dojo Location:</td>
            <td>${location}</td>
        </tr>
        <tr>
            <td>Favorite Language:</td>
            <td>${lang}</td>
        </tr>
        <tr>
            <td>Comment:</td>
            <td>${comment}</td>
        </tr>
    </table>

    <a href="/" class="btn btn-primary" >Go Back</a>
</body>
</html>