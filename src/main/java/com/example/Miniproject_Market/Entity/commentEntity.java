package com.example.Miniproject_Market.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Comments")
public class commentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // PK 역할. 코멘트 Id

    private Long itemId;    // FK 역할. 등록된 판매게시글 Id
    @Column(nullable = false, length = 20)
    private String writer;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String content;
    private String reply;
}
