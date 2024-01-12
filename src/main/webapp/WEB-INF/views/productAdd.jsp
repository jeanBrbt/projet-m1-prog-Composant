<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Produit</title>
</head>
<body>
<h2>Ajouter un Produit</h2>
<form action="ProductAddServlet" method="post">
    <input type="text" name="productName" placeholder="Nom" required><br>
    <input type="text" name="productDescription" placeholder="Description" required><br>
    <input type="number" name="productPrice" placeholder="Prix" required><br>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
