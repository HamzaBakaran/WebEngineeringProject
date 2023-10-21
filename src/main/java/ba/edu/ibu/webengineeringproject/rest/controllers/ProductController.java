package ba.edu.ibu.webengineeringproject.rest.controllers;

import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.core.service.ProductService;
import ba.edu.ibu.webengineeringproject.rest.dto.ProductRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }
    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<Product> register(@RequestBody ProductRequestDTO product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Product> updateUser(@PathVariable String id, @RequestBody ProductRequestDTO product) {
        return ResponseEntity.ok(productService.updateProduct(id,product));
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }









}
