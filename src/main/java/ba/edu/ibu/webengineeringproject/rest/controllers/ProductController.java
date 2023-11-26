package ba.edu.ibu.webengineeringproject.rest.controllers;

import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.core.service.ProductService;
import ba.edu.ibu.webengineeringproject.rest.dto.ProductRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@SecurityRequirement(name = "JWT Security")
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
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<Product> register(@RequestBody ProductRequestDTO product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductRequestDTO product) {
        return ResponseEntity.ok(productService.updateProduct(id,product));
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/count")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public Map<String, Long> countOrders() {
        long totalProducts = productService.countTotalProducts();

        Map<String, Long> response = new HashMap<>();
        response.put("totalProducts", totalProducts);

        return response;
    }








}
