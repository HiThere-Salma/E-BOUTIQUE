<%--
  Created by IntelliJ IDEA.
  User: myous
  Date: 24/05/2025
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Clients</title>
</head>
<body>

<h2>Liste des clients</h2>

<table border="1">
    <tr>
        <th>Code</th>
        <th>Nom</th>
    </tr>

    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.code}</td>
            <td>${client.nom}</td>
        </tr>
    </c:forEach>
</table>

<hr>

<h3>Ajouter un client</h3>
<form method="post" action="${pageContext.request.contextPath}/clients/add">
    Code: <input type="text" name="code" /> <br/>
    Nom : <input type="text" name="nom" /> <br/>
    <input type="submit" value="Ajouter" />
</form>

</body>
</html>

