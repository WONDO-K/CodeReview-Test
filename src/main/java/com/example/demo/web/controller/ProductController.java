// web/ProductController.java
package com.example.demo.web.controller;

import com.example.demo.domain.Product;
import com.example.demo.domain.dto.DecreaseStockRequest;
import com.example.demo.domain.dto.ProductResponse;
import com.example.demo.domain.dto.UpdatePriceRequest;
import com.example.demo.service.ProductService;
import com.example.demo.web.dto.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping()
    public ResponseEntity<Page<ProductResponse>> searchProducts(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable
    ) {
        Page<ProductResponse> result =
                productService.search(keyword, minPrice, maxPrice, pageable);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/{productId}/decrease-stock")
    public ResponseEntity<Void> decreaseStock(
            @PathVariable Long productId,
            @RequestBody DecreaseStockRequest request
    ) {
        productService.decreaseStock(productId, request.quantity());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{productId}/price")
    public ResponseEntity<Void> updatePrice(
            @PathVariable Long productId,
            @RequestBody UpdatePriceRequest request
    ) {
        productService.updatePrice(productId, request.price());
        return ResponseEntity.noContent().build();
    }
}
