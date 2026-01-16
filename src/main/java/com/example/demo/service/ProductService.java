// service/ProductService.java
package com.example.demo.service;

import com.example.demo.web.dto.ProductCreateRequest;

public interface ProductService {
    Long create(ProductCreateRequest request);
}
