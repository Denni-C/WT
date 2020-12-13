<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="intn"/>
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cuprum:ital@1&display=swap" rel="stylesheet">
    <title><fmt:message key="auth"/></title>
    <style>
        <%@include file="../../../Styles/style.css" %>
    </style>
</head>
<body>
<h1><fmt:message key="auth"/></h1>
<form action="${pageContext.request.contextPath}/rent/auth" method="post">
    <input type="hidden" name="command" value="authorization">
    <label for="login"><fmt:message key="username"/></label>
    <input id="login" name="login" type="text">
    <label for="password"><fmt:message key="pass"/></label>
    <input id="password" name="password" type="password">
    <input type="submit">
</form>
</body>
</html>