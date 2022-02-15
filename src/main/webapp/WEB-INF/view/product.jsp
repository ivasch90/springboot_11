<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2>Manufacturer: <%--${message.to}--%></h2>
<h2>Product title: ${product.title}</h2>
<h2>Product cost: ${product.cost}</h2>

<c:url var="deleteUrl" value="/products/delete">
    <c:param name="id" value="${product.id}"/>
</c:url>

<a href="${deleteUrl}">DELETE</a>

<br>
</body>
</html>