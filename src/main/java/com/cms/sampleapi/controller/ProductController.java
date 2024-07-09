package com.cms.sampleapi.controller;

import com.cms.sampleapi.model.Product;
import com.cms.sampleapi.service.ProductService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return HttpStatus.CREATED.getReasonPhrase();
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            product.setId(id); // Ensure the correct ID is set
            productService.saveProduct(product);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}