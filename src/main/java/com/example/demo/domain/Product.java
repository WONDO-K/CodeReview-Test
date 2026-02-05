// domain/Product.java
package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int stock;


    public void decreaseStock(int quantity) {
        if (this.stock < quantity) {
            throw new RuntimeException("재고 부족");
        }
        this.stock -= quantity;
    }
}
