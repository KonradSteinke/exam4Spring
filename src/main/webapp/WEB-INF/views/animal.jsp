<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spring MVC List of objects display</title>
</head>
<body>
<table>




    <c:forEach items="${animals}" var="animal" varStatus="tagStatus">

        <a href='<c:url value="/animal/${animal.id}/delete" />'>usun ${animal.id}  </a>
        <a href='<c:url value="/animal/${animal.id}/status" />'>status ${animal.id}  </a>
        <tr>
            <td>${animal.id}</td>
            <td>${animal.name}</td>
            <td>${animal.type}</td>
            <td>${animal.status}</td>
        </tr>
    </c:forEach>



</table>
</body>
</html>
