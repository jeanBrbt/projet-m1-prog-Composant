<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Ajouter un Produit</title>
</head>
<body>
    <div class="container">
        <h2>Ajouter un Produit</h2>
        <form action="ProductAddServlet" method="post">
            <label for="productName">Nom:</label>
            <input type="text" id="productName" name="productName" placeholder="Entrez le nom" required>

            <label for="productDescription">Description:</label>
            <textarea id="productDescription" name="productDescription" placeholder="Entrez la description" required></textarea>

            <label for="productPrice">Prix:</label>
            <input type="number" id="productPrice" name="productPrice" placeholder="Entrez le prix" required>

            <button type="submit">Ajouter</button>
        </form>
    </div>
</body>
</html>
