package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.shop.ejb.ProductManagementBean;
import com.shop.model.Product;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ProductEditServlet")
public class ProductEditServlet extends HttpServlet {

    @EJB
    private ProductManagementBean productManagementBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long productId = Long.parseLong(request.getParameter("id"));
        Product product = productManagementBean.getProduct(productId);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/WEB-INF/views/productEdit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long productId = Long.parseLong(request.getParameter("productId"));
        String name = request.getParameter("productName");
        String description = request.getParameter("productDescription");
        double price = Double.parseDouble(request.getParameter("productPrice"));

        Product product = productManagementBean.getProduct(productId);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        productManagementBean.updateProduct(product);

        response.sendRedirect(request.getContextPath() + "/ProductListServlet");
    }
}