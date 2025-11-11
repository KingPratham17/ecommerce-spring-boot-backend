package com.ecommerce.service;

import com.ecommerce.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product product);

    void deleteProduct(Long productId);

    List<Product> getAllProducts();

    Product getProductById(Long productId);
}
