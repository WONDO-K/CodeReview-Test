// web/ProductController.java
package com.example.demo.web.controller;

import com.example.demo.service.ProductService;
import com.example.demo.web.dto.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public Long create(@RequestBody ProductCreateRequest request) {
        return productService.create(request);
    }
}
