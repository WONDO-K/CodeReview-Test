// service/ProductServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.web.dto.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Long create(ProductCreateRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();

        return productRepository.save(product).getId();
    }
}
