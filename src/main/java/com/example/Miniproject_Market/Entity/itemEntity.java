package com.example.Miniproject_Market.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data   // Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode
@Entity // JPA가 관리. DB 테이블과 클래스 매핑
@Table(name = "items")
public class itemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 매핑 전략 IDENTITY로 설정
    private Long id;    // PK 역할

    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column
    private String image_url;
    @Column
    private Integer minPriceWanted;
//    @ColumnDefault("판매중")   // jpa.hiberanate.ddl-auto;create-drop일 때만 적용됨
    @Column
    private String status = "판매중";
    @Column(nullable = false, length = 20)
    private String writer;
    @Column(nullable = false)
    private String password;
}
