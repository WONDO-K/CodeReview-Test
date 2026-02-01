// web/ProductController.java
package com.example.demo.web.controller;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.web.dto.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public Long create(@RequestBody ProductCreateRequest request) {
        return productService.create(request);
    }

    @PostMapping("/delete/{productId}")
    public ResponseEntity<Void> delete(@PathVariable Long productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build(); // 요청 성공, 클라이언트에게 내려줄 응답바디는 없다.
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }
}
