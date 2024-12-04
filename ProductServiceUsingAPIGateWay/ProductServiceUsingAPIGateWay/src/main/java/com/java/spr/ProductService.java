package com.java.spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create a new Product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Get a Product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Get all Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Update Product details
    public Product updateProduct(Long id, Product productDetails) {
        if (productRepository.existsById(id)) {
            productDetails.setId(id);
            return productRepository.save(productDetails);
        }
        return null;
    }

    // Delete a Product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
