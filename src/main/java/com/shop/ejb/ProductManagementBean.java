package com.shop.ejb;
import com.shop.model.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductManagementBean {

    @PersistenceContext
    private EntityManager entityManager;
    //ajoute un produit
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

   // récupére un produit
    public Product getProduct(Long id) {
        return entityManager.find(Product.class, id);
    }

    // récupére tous les produits
    public List<Product> getAllProducts() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    // récupére les produits ayant la chaine de charactére name dans leur nom
    public List<Product> getProductsByName(String name) {
        return entityManager.createQuery("SELECT p FROM Product p WHERE p.name LIKE :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
    //mettre a jour les produits

    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    //suprimer un produit par Id
    public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
