package ba.edu.ibu.webengineeringproject.core.service;

import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.core.model.enums.ProductType;
import ba.edu.ibu.webengineeringproject.core.repository.ProductRepository;
import ba.edu.ibu.webengineeringproject.rest.dto.ProductRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureMockMvc
@SpringBootTest
class ProductServiceTest {

    @MockBean
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @Test
    public void shouldReturnProductWhenCreated() {
        Product product=new Product();
        product.setProductType(ProductType.ELECTRONIC);
        product.setName("test1");
        product.setQuantity(2);
        product.setCostPrice(20.500);
        product.setSellingPrice(21.500);
        product.setUrl("test1");

        Mockito.when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);
        Product savedProduct=productService.addProduct(new ProductRequestDTO(product));
        Assertions.assertEquals(product.getProductType(),savedProduct.getProductType());


    }
    @Test
    public void shouldFindProductById() {
        String productId = "1";
        Product product = new Product();
        product.setId(productId);
        product.setProductType(ProductType.ELECTRONIC);
        product.setName("test1");
        product.setQuantity(2);
        product.setCostPrice(20.500);
        product.setSellingPrice(21.500);
        product.setUrl("test1");

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<Product> foundProduct = productService.findById(productId);
        Assertions.assertTrue(foundProduct.isPresent());
        Assertions.assertEquals(productId, foundProduct.get().getId());
    }
    @Test
    public void shouldDeleteProduct() {
        String productId = "1";
        Product existingProduct = new Product();
        existingProduct.setId(productId);
        existingProduct.setProductType(ProductType.ELECTRONIC);
        existingProduct.setName("test1");
        existingProduct.setQuantity(2);
        existingProduct.setCostPrice(20.500);
        existingProduct.setSellingPrice(21.500);
        existingProduct.setUrl("test1");

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));

        productService.deleteProduct(productId);

        Mockito.verify(productRepository, Mockito.times(1)).delete(existingProduct);
    }

}