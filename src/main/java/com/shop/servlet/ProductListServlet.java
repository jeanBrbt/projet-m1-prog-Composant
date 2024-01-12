
package com.shop.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.shop.ejb.ProductManagementBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.shop.model.Product;
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {

    @EJB
    private ProductManagementBean productManagementBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productManagementBean.getAllProducts();
        for (Product product : products) {
            System.out.println("test");
            System.out.println(product.getName());
        }
        //  System.out.println(products);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/views/productList.jsp").forward(request, response);
    }
}
