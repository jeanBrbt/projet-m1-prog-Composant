package com.shop.servlet;
import com.shop.ejb.ProductManagementBean;
import com.shop.model.Product;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {

    @EJB
    private ProductManagementBean productManagementBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/productAdd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//pour les accents
        String name = request.getParameter("productName");
        String description = request.getParameter("productDescription");
        double price = Double.parseDouble(request.getParameter("productPrice"));
        System.out.println(name);

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        productManagementBean.addProduct(product);

        response.sendRedirect(request.getContextPath() + "/ProductListServlet");
    }
}