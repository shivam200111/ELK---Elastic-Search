package com.example.springbootelasticsearchexample.controller;

import com.example.springbootelasticsearchexample.entity.Product;
import com.example.springbootelasticsearchexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Fetch all products
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.getProducts());
    }

    // Insert a new product
    @PostMapping("/insert")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        if (product == null) {
            return ResponseEntity.badRequest().body(null);
        }
        Product createdProduct = productService.insertProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    // Update an existing product
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id) {
        try {
            Product updatedProduct = productService.updateProduct(product, id);
            return ResponseEntity.ok(updatedProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete a product by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
