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
    <form:form action="/ninjas/create" method="post" modelAttribute="ninja">
        <p>
            <form:label path="dojo">Dojo</form:label>
			<form:errors path="dojo" class = "text-danger" />
			<form:select path="dojo" class="form-select">
					<c:forEach items='${allDojos}' var='d'>
						<option value="${d.id}">${d.name}</option>
					</c:forEach>
					
				</form:select>
        </p>
        <p>
			<form:label path="firstName">First name</form:label>
			<form:errors path="firstName" class = "text-danger" />
			<form:input path="firstName"/>
		</p>
        <p>
			<form:label path="lastName">Last name</form:label>
			<form:errors path="lastName" class = "text-danger" />
			<form:input path="lastName"/>
		</p>
        <p>
			<form:label path="age">Age</form:label>
			<form:errors path="age" class = "text-danger" />
			<form:input path="age"/>
		</p>
        <input class="btn btn-primary" type="submit" value="Create"/>
    </form:form>
</body>
</html>