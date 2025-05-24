<%--
  Created by IntelliJ IDEA.
  User: myous
  Date: 24/05/2025
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Comptes</title>
</head>
<body>

<h2>Liste des comptes</h2>

<table border="1">
    <tr>
        <th>Numéro</th>
        <th>Solde</th>
        <th>Date de création</th>
        <th>Type</th>
    </tr>
    <c:forEach var="c" items="${comptes}">
        <tr>
            <td>${c.numero}</td>
            <td>${c.solde}</td>
            <td>${c.dateCreation}</td>
            <td>${c.type}</td>
        </tr>
    </c:forEach>
</table>

<hr>

<h3>Ajouter un compte</h3>
<form method="post" action="${pageContext.request.contextPath}/comptes/add">
    Numéro: <input type="text" name="numero"/><br/>
    Solde: <input type="text" name="solde"/><br/>
    Type :
    <select name="type">
        <option value="CC">Compte Courant</option>
        <option value="CE">Compte Epargne</option>
    </select><br/>
    Découvert (CC) : <input type="text" name="decouvert"/><br/>
    Taux (CE) : <input type="text" name="taux"/><br/>
    Code Client : <input type="text" name="codeClient" value="C001"/><br/>
    Code Employé : <input type="text" name="codeEmploye" value="E001"/><br/>
    <input type="submit" value="Ajouter"/>
</form>

</body>
</html>

