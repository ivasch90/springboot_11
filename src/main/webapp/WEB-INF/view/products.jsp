<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product List</title
</head
<body>
<%--@elvariable id="productList" type="ru.gb.spring1.controller"--%>
<h1>Product list: </h1>
<c:url var="sortBy" value="/products/all">
    <c:param name="direction"/>
</c:url>
<p>Sort by Cost: </p>
<a href="/products/all?direction=asc">ASC</a>
<a href="/products/all?direction=desc">DESK</a>
<ul>
    <c:forEach var="product" items="${productList}">
        <c:url var="viewUrl" value="/products/ + ${product.id}"/>
    <li>
        <a href="${viewUrl}"value=View</a>
        <br>
        Product title: ${product.title}
        <br>
        Cost: ${product.cost}
        <br>
    </li>
    </c:forEach>
</ul>

</body>
</html>