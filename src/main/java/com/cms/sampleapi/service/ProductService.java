package com.cms.sampleapi.service;

import com.cms.sampleapi.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface ProductService {
    Product getProductById(Long id);
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);

    List<Product> getAllProducts();
}
