<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/EditPage.css">
    <title>Éditer un Produit</title>
</head>
<body>
    <div class="container">
        <h2>Éditer un Produit</h2>
        <form action="ProductEditServlet" method="post"  accept-charset="UTF-8">
            <input type="hidden" name="productId" value="${product.id}">
            <label for="productName">Nom:</label>
            <input type="text" id="productName" name="productName" value="${product.name}" required><br>

            <label for="productDescription">Description:</label>
            <textarea id="productDescription" name="productDescription" required>${product.description}</textarea><br>

            <label for="productPrice">Prix:</label>
            <input type="number" id="productPrice" name="productPrice" value="${product.price}" required><br>

            <button type="submit">Éditer</button>
        </form>
    </div>
</body>
</html>
