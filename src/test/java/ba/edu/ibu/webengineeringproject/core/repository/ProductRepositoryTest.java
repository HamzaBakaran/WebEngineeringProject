package ba.edu.ibu.webengineeringproject.core.repository;

import ba.edu.ibu.webengineeringproject.core.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldReturnAllProducts(){
        List<Product> products=productRepository.findAll();
        Assertions.assertEquals("GARMIN",products.get(0).getName());

    }
}