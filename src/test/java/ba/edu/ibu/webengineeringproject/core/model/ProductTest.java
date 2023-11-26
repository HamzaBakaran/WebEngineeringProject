package ba.edu.ibu.webengineeringproject.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void shoudCreateNewProduct(){
        Product product1=new Product();;

        Assertions.assertNotNull(product1);


    }
}