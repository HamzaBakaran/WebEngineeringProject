package ba.edu.ibu.webengineeringproject.core.service;

import ba.edu.ibu.webengineeringproject.core.exceptions.repository.ResourceNotFoundException;
import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.core.repository.ProductRepository;
import ba.edu.ibu.webengineeringproject.rest.dto.ProductRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;

    }
    public List<Product> findAllProducts() {
        List<Product> products =productRepository.findAll();

        return products;

    }
    public Optional<Product> findById(String id) {
        Optional<Product> product=productRepository.findById(id);
        if (product.isEmpty()){
            throw new ResourceNotFoundException("The product with the given ID does not exist.");
        }
        return Optional.of(product.get());

    }
    public Product addProduct(ProductRequestDTO payload){
        Product product=productRepository.save(payload.toEntity());
        return product;

    }
    public Product updateProduct(String id,ProductRequestDTO payload){
        Optional<Product>product=productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        Product updatedProduct= payload.toEntity();
        updatedProduct.setId(product.get().getId());
        updatedProduct=productRepository.save(updatedProduct);
        return updatedProduct;
    }
    public void deleteProduct(String id){
        Optional<Product> product=productRepository.findById(id);
        product.ifPresent(productRepository::delete);
    }

}
