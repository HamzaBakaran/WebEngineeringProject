package ba.edu.ibu.webengineeringproject.core.repository;

import ba.edu.ibu.webengineeringproject.core.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository(){
        this.products= Arrays.asList(
                new Product(1L, "Test Product", 22.5, 25.0, "https://example.com/product", 10),
                new Product(2L, "Test Product2", 22.5, 25.0, "https://example.com/product", 10)

        );
    }
    public List<Product> findAll(){
        return products;
    }
    // Function to find a product by ID
    public Product findById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product; // Return the product if the ID matches
            }
        }
        return null; // Return null if no matching product is found
    }

}
