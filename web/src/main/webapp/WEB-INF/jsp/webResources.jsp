<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>web resources</title>
</head>
<body>
<h2>all web resources: </h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>url</th>
        <th>status</th>
        <th>delete</th>
    </tr>
    <c:forEach var="res" items="${webResources}">
        <tr>
            <td>${res.id}</td>
            <td>${res.resourceName}</td>
            <td>${res.resourceUrl}</td>
            <td>${res.resourceStatus}</td>
            <td><a href="<c:url value="/deleteWebResource?w_id=${res.id}"/>">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value="/addWebResource"/>">add new web resource</a><br>
</body>
</html>
