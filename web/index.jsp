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
    <%@include file="Styles/style.css" %>
  </style>
  <title><fmt:message key="rent"/></title>
</head>
<body>
<h1><fmt:message key="rent"/></h1>
<p><fmt:message key="rent_text"/></p>
<a href="${pageContext.request.contextPath}/rent/regForm"><fmt:message key="sign_up"/></a>
<a href="${pageContext.request.contextPath}/rent/authForm"><fmt:message key="sign_in"/></a>
</body>
</html>
