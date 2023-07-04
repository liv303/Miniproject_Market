package com.example.Miniproject_Market.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity // JPA가 관리. DB 테이블과 클래스 매핑
@Table(name = "Negotiation")
public class negoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // PK 역할. 구매 제안 Id

    private Long itemId;    // 대상 물품
    private Long suggestedPrice;    // 제안 가격
    private String status;
    private String writer;
    @Column(nullable = false)
    private String password;
}
