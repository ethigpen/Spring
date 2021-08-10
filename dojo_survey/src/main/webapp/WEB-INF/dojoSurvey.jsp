<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Survey</title>
</head>
<body class="container">
    <form action="/result" method="POST">
        <div class="mb-3">
            <label for="name" class="form-label">Your Name:</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="mb-3">
            <label for="location" class="form-label">Dojo Location:</label>
            <select class="form-select" name="location">
                <option value="San Jose">San Jose</option>
                <option value="Texas">Texas</option>
                <option value="Online">Online</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="language" class="form-label">Favorite Language:</label>
            <select class="form-select" name="language">
                <option value="Python">Python</option>
                <option value="Java">Java</option>
                <option value="Html/CSS">Html/CSS</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="comment" class="form-label">Comment (optional):</label>
            <textarea class="form-control" name="comment" rows="3"></textarea>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</body>
</html>