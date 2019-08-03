<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>web resources</title>
</head>
<body>
<h2><a href="<c:url value="/webResources"/> ">all web resources:</a></h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>url</th>
        <th>status</th>
        <th>duration</th>
        <th>delete</th>
    </tr>
    <c:forEach var="res" items="${webResources}">
        <tr bgcolor="${res.color}">
            <td>${res.id}</td>
            <td>${res.resourceName}</td>
            <td>${res.resourceUrl}</td>
            <td>${res.resourceStatus}</td>
            <td>${res.responseDuration}</td>
            <td><a href="<c:url value="/deleteWebResource?w_id=${res.id}"/>">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value="/addWebResource"/>">add new web resource</a><br>
</body>
</html>
