// service/ProductService.java
package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.web.dto.ProductCreateRequest;

import java.util.Optional;

public interface ProductService {
    Long create(ProductCreateRequest request);

    void delete(Long productId);

    Optional<Product> getProduct(Long productId);
}
