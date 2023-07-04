package com.example.Miniproject_Market.dto.negoDto;

import com.example.Miniproject_Market.Entity.negoEntity;
import lombok.Data;

@Data
public class negoDto {
    private Long id;    // 구매 제안 Id
    private Long itemId;    // 대상 물품
    private Long suggestedPrice;    // 제안 가격
    private String status;
    private String writer;
    private String password;

    public static negoDto fromNegoEntity(negoEntity entity) {
        negoDto dto = new negoDto();
        dto.setId(entity.getId());
        dto.setItemId(entity.getItemId());
        dto.setSuggestedPrice(entity.getSuggestedPrice());
        dto.setStatus(entity.getStatus());
        dto.setWriter(entity.getWriter());
        dto.setPassword(entity.getPassword());
        return dto;
    }
}