<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Éditer un Produit</title>
</head>
<body>
<h2>Éditer un Produit</h2>
<form action="ProductEditServlet" method="post">
    <input type="hidden" name="productId" value="${product.id}">
    <input type="text" name="productName" value="${product.name}" required><br>
    <input type="text" name="productDescription" value="${product.description}" required><br>
    <input type="number" name="productPrice" value="${product.price}" required><br>
    <input type="submit" value="Éditer">
</form>
</body>
</html>
