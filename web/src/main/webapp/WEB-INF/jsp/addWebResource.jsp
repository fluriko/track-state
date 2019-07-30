<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>add new web resource</title>
</head>
<body>
<spring:form modelAttribute="webResource" method="post" action="/addWebResource">

    <label for="resourceName">resource name</label>
    <spring:input path="resourceName" id="resourceName"/>

    <label for="resourceUrl">resource url</label>
    <spring:input path="resourceUrl" id="resourceUrl"/>

    <button type="submit">submit</button>
</spring:form>
</body>
</html>
