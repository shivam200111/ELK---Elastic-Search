package com.example.springbootelasticsearchexample.service;

import com.example.springbootelasticsearchexample.entity.Product;
import com.example.springbootelasticsearchexample.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product insertProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return productRepo.save(product);
    }

    public Product updateProduct(Product product, int id) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        Optional<Product> existingProductOptional = productRepo.findById(id);
        if (existingProductOptional.isEmpty()) {
            throw new IllegalArgumentException("Product with ID " + id + " not found");
        }

        Product existingProduct = existingProductOptional.get();
        // Update the fields you want to modify
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        // Add more fields as needed

        return productRepo.save(existingProduct); // Save the updated product
    }

    public void deleteProduct(int id) {
        if (!productRepo.existsById(id)) {
            throw new IllegalArgumentException("Product with ID " + id + " does not exist");
        }
        productRepo.deleteById(id);
    }
}
