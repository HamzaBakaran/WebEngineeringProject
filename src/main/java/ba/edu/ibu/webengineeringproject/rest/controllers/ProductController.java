package ba.edu.ibu.webengineeringproject.rest.controllers;

import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.core.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }
    // Endpoint to find a product by ID
    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable int productId) {
        return (Product) productService.findById(productId);
    }





}
