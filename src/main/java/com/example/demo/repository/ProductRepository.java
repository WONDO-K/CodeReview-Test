// repository/ProductRepository.java
package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
        SELECT p FROM Product p
        WHERE (:keyword IS NULL OR p.name LIKE %:keyword%)
        AND (:minPrice IS NULL OR p.price >= :minPrice)
        AND (:maxPrice IS NULL OR p.price <= :maxPrice)
    """)
    Page<Product> search(
            String keyword,
            Integer minPrice,
            Integer maxPrice,
            Pageable pageable
    );
}
