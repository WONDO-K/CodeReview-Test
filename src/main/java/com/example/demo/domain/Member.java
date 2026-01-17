// domain/Member.java
package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    // 예시: 이메일을 고유값으로 둠 (코드리뷰 포인트로도 좋음)
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    public void changeUsername(String username) {
        this.username = username;
    }


}
