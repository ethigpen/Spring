    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body class = "container">
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Creator</th>
                <th scope="col">Current Version</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allLangs}" var = "l">
                <tr>
                    <td><a href="/languages/${l.id}">${l.name}</a></td>
                    <td>${l.creator}</td>
                    <td>${l.currentVersion}</td>
                    <td><a href="/languages/edit/${l.id}">Edit</a> | <a href="/languages/delete/${l.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <form:form action="/languages/create" method="post" modelAttribute="lang">
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