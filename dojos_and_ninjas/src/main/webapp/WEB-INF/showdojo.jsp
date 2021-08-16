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
    <h1>${dojo.name} Location Ninjas</h1>
<table class="table table-bordered table-striped">
    <thead>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Age</td>
    </thead>
    <tbody>
        <c:forEach items='${dojo.ninjas}' var='n'>
            <tr>
				<td>${n.firstName}</td>
                <td>${n.lastName}</td>
                <td>${n.age}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>