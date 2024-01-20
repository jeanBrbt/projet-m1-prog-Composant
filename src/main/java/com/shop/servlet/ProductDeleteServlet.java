package com.shop.servlet;
import com.shop.ejb.ProductManagementBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {

    @EJB
    private ProductManagementBean productManagementBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'ID du produit à supprimer depuis les paramètres de la requête
        String productIdStr = request.getParameter("id");

        if (productIdStr != null && !productIdStr.isEmpty()) {
            try {
                // Convertir l'ID en Long
                Long productId = Long.parseLong(productIdStr);

                // Appeler la méthode pour supprimer le produit
                productManagementBean.deleteProduct(productId);

                // Rediriger vers la page de liste des produits après la suppression
                response.sendRedirect(request.getContextPath() + "/ProductListServlet");
            } catch (NumberFormatException e) {
                // Gérer les erreurs de conversion d'ID
                response.getWriter().println("ID de produit invalide.");
            } catch (Exception e) {
                // Gérer d'autres erreurs possibles lors de la suppression
                response.getWriter().println("Erreur lors de la suppression du produit : " + e.getMessage());
            }
        } else {
            response.getWriter().println("ID de produit manquant.");
        }
    }
}