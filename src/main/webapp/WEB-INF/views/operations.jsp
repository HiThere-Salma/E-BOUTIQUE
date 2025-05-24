<%--
  Created by IntelliJ IDEA.
  User: myous
  Date: 24/05/2025
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Opérations bancaires</title>
</head>
<body>

<h2>Effectuer une opération</h2>

<form method="post" action="${pageContext.request.contextPath}/operations/add">
    Type d'opération :
    <select name="type" onchange="toggleFields(this.value)">
        <option value="versement">Versement</option>
        <option value="retrait">Retrait</option>
        <option value="virement">Virement</option>
    </select><br/>

    Compte source :
    <select name="codeCompte">
        <c:forEach var="c" items="${comptes}">
            <option value="${c.numero}">${c.numero}</option>
        </c:forEach>
    </select><br/>

    Compte destinataire (pour virement) :
    <select name="codeCompte2" id="compte2">
        <option value="">-- Choisir --</option>
        <c:forEach var="c" items="${comptes}">
            <option value="${c.numero}">${c.numero}</option>
        </c:forEach>
    </select><br/>

    Montant : <input type="text" name="montant"/><br/>
    Code Employé : <input type="text" name="codeEmploye" value="E001"/><br/>
    <input type="submit" value="Valider"/>
</form>

<script>
    function toggleFields(op) {
        document.getElementById("compte2").disabled = (op !== "virement");
    }
</script>

<hr>
<h3>Liste des comptes</h3>
<table border="1">
    <tr>
        <th>Numéro</th>
        <th>Solde</th>
        <th>Type</th>
    </tr>
    <c:forEach var="c" items="${comptes}">
        <tr>
            <td>${c.numero}</td>
            <td>${c.solde}</td>
            <td>${c.type}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

