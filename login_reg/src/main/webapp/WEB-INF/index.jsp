<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body class="container d-flex">
		<div class="m-3 flex-fill">
            <h3>Register</h3>
            <h4 class="text-danger">${notAllowed}</h4>
            <form:form action="/register" method="post" modelAttribute="newUser">
                <div class="form-group">
                    <label>Username:</label>
                    <form:input path="userName" class="form-control" />
                    <form:errors path="userName" class="text-danger" />
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <form:input path="email" class="form-control" />
                    <form:errors path="email" class="text-danger" />
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <form:password path="password" class="form-control" />
                    <form:errors path="password" class="text-danger" />
                </div>
                <div class="form-group">
                    <label>Confirm Password:</label>
                    <form:password path="confirm" class="form-control" />
                    <form:errors path="confirm" class="text-danger" />
                </div>
                <input type="submit" value="Register" class="btn btn-primary mt-1" />
            </form:form>
        </div>
        <div class="m-3 flex-fill">
            <h3>Login</h3>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div class="form-group">
				<label>Email:</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group">
				<label>Password:</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			<input type="submit" value="Login" class="btn btn-primary mt-1" />
        </form:form>
        </div>
</body>
</html>