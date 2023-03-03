package com.revature.services;

import com.revature.models.Product;
import com.revature.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Optional<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product save(Product p) {
        return productRepository.save(p);
    }
}
