<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojo details.</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1><c:out value="${dojo.location}">Location Name.</c:out></h1>
<table class="table table-dark">
    <thead>
    <tr>
        <th  scope="col">First Name</th>
        <th  scope="col">Last Name</th>
        <th  scope="col">Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dojo.ninjas}" var="ninja">
        <tr>
            <td> <c:out value="${ninja.firstName}"></c:out></td>
            <td> <c:out value="${ninja.lastName}"></c:out></td>
            <td> <c:out value="${ninja.age}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>