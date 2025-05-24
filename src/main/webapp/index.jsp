<%--
  Created by IntelliJ IDEA.
  User: myous
  Date: 24/05/2025
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Smart Banque - Accueil</title>
</head>
<body>

<h1>Bienvenue dans Smart Banque</h1>

<ul>
  <li><a href="${pageContext.request.contextPath}/clients">👤 Gestion des Clients</a></li>
  <li><a href="${pageContext.request.contextPath}/comptes">🏦 Gestion des Comptes</a></li>
  <li><a href="${pageContext.request.contextPath}/operations">💸 Effectuer une opération</a></li>
  <li>
    <form action="" onsubmit="event.preventDefault(); window.location.href='${pageContext.request.contextPath}/operations/' + this.code.value;">
      🔍 Voir historique du compte :
      <input type="text" name="code" placeholder="ex: 001"/>
      <input type="submit" value="Afficher"/>
    </form>
  </li>
</ul>

</body>
</html>

