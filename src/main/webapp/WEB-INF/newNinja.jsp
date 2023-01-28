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
    <title>Insert title here</title>
</head>
<body>

<h1>New Ninja</h1>
<%--@elvariable id="ninja" type="java"--%>
<form:form action="/ninjas/createNinja" method="post" modelAttribute="ninja">
    <p>
        <form:label path="dojo">Dojo:</form:label>

        <form:select path="dojo">

            <c:forEach var="eachDojo" items="${dojos}">

                <option value="${eachDojo.id}"><c:out value="${eachDojo.location}"/></option>

            </c:forEach>

        </form:select>
    </p>
    <p>
        <form:label path="firstName">First Name:</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>

    <p>
        <form:label path="lastName">Last Name:</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age:</form:label>
        <form:errors path="age"/>
        <form:input path="age"/>
    </p>

<button>Create<button
</form:form>

</body>
</html>