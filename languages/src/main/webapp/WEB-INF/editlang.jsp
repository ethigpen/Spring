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
<body class="container">
    <a href="/languages">Dashboard</a>
    <a href="/languages/delete/${lang.id}">Delete</a>

    <form:form action="/languages/update/${lang.id}" method="post" modelAttribute="lang">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name" class = "text-danger" />
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator" class = "text-danger"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion" class = "text-danger"/>     
        <form:input  path="currentVersion"/>
    </p>  
    <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>
</body>
</html>