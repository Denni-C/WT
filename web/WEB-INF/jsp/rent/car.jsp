<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cuprum:ital@1&display=swap" rel="stylesheet">
    <style>
        <%@include file="../../../Styles/style.css" %>
    </style>
    <meta charset="UTF-8">
    <title>Cars catalog</title>
</head>
<body>

<ul>
    <c:forEach var="car" items="${cars}">
        <li>
            <form action="${pageContext.request.contextPath}/rent/rent-a-car?id=${car.id}" method="get">
                <fmt:message key="mark"/>${car.mark}<br/>
                <fmt:message key="color"/>${car.color}<br/>
                <fmt:message key="cost"/>${car.mark}<br/>
            <input type="button">
            </form>
        </li>
    </c:forEach>
</ul>


</body>
</html>