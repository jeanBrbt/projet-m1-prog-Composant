<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shop.model.Product" %>

<html lang="fr">
<head>
    <title>Liste des Produitsss</title>
    <link rel="stylesheet" type="text/css" href="css/productList.css">
</head>
  
<body>
    <div class="container">
        <h2>Liste des Produits</h2>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
        %>
        <a class="add-link" href="ProductAddServlet">Add Product</a>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Prix</th>
                <th class="actions-header">Actions</th>
            </tr>
            </thead>
            <%
                for (Product product : products)
                {
            %>
            <tr>
                <td>
                    <%= product.getId() %>
                </td>
                <td>
                    <%= product.getName() %>
                </td>
                <td>
                    <%= product.getDescription() %>
                </td>
                <td>
                    <%= product.getPrice() %>
                </td>
                <td class="actions-cell">
                    <a class="edit-link" href="ProductEditServlet?id=<%=product.getId() %>">Edit</a>
                    <a class="delete-link" href="ProductDeleteServlet?id=<%=product.getId() %>">Delete</a>
                </td>
            </tr>

            <%
                }
            %>
        </table>
    </div>
</body>
</html>
