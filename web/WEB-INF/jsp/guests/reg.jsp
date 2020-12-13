<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="intn"/>
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cuprum:ital@1&display=swap" rel="stylesheet">
    <style>
        <%@include file="../../../Styles/style.css" %>
    </style>
    <title><fmt:message key="reg"/></title>
</head>
<body>
<h1><fmt:message key="reg"/></h1>
<form method="post" action="${pageContext.request.contextPath}/rent/reg">
    <input type="hidden" name="command" value="registration">
    <label for="name"><fmt:message key="name"/></label>
    <input id="name" name="name" type="text">
    <label for="surname"><fmt:message key="surname"/></label>
    <input id="surname" name="surname" type="text">
    <label for="login"><fmt:message key="username"/></label>
    <input id="login" name="login" type="text">
    <label for="email"><fmt:message key="email"/></label>
    <input id="email" name="email" type="email">
    <label for="password"><fmt:message key="pass"/></label>
    <input id="password" name="password" type="password">
    <input type="submit" >
</form>
</body>
</html>
