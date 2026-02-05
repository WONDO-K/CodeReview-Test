// service/ProductService.java
package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.domain.dto.ProductResponse;
import com.example.demo.web.dto.ProductCreateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Long create(ProductCreateRequest request);

    void delete(Long productId);

    Optional<Product> getProduct(Long productId);

    Page<ProductResponse> search(
            String keyword,
            Integer minPrice,
            Integer maxPrice,
            Pageable pageable
    );

    void decreaseStock(Long productId, int quantity);

    void updatePrice(Long productId, int price);

}
