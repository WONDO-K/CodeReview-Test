// service/ProductServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.domain.Product;
import com.example.demo.domain.dto.ProductResponse;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.web.dto.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Page<ProductResponse> search(
            String keyword,
            Integer minPrice,
            Integer maxPrice,
            Pageable pageable
    ) {

        Page<Product> page =
                productRepository.search(keyword, minPrice, maxPrice, pageable);

        return page.map(ProductResponse::from);
    }

    @Override
    @Transactional
    public void decreaseStock(Long productId, int quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품 없음"));

        product.decreaseStock(quantity);
    }

    @Override
    @Transactional
    public void updatePrice(Long productId, int price) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품 없음"));

        product.updatePrice(price);
    }

}
