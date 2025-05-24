<%--
  Created by IntelliJ IDEA.
  User: myous
  Date: 24/05/2025
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Historique des opérations</title>
</head>
<body>

<h2>Historique des opérations du compte : ${codeCompte}</h2>

<table border="1">
  <tr>
    <th>Numéro</th>
    <th>Date</th>
    <th>Montant</th>
    <th>Type</th>
  </tr>
  <c:forEach var="op" items="${operations}">
    <tr>
      <td>${op.numero}</td>
      <td>${op.dateOperation}</td>
      <td>${op.montant}</td>
      <td>${op.type}</td>
    </tr>
  </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/">← Retour</a>

</body>
</html>

