<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shop.model.Product" %>

<html>
<head>
    <title>Liste des Produits</title>
    <link rel="stylesheet" type="text/css" href="css/productList.css">
</head>
<body>
<h2>Liste des Produits</h2>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<table>
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
        <td>
            <a href="ProductEditServlet?id=<%=product.getId() %>">Edit</a>
            <a href="ProductDeleteServlet?id=<%=product.getId() %>">Delete</a>
        </td>
    </tr>

    <%
        }
    %>
</table>
<a href="ProductAddServlet">Add Product</a>
</body>
</html>
