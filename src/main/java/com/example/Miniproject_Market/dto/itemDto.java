package com.example.Miniproject_Market.dto;

import com.example.Miniproject_Market.Entity.itemEntity;
import lombok.Data;

@Data
public class itemDto {
    private Long id;
    private String title;
    private String description;
    private Integer minPriceWanted;
    private String writer;

    public static itemDto fromEntity(itemEntity entity) {
        itemDto dto = new itemDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setMinPriceWanted(entity.getMinPriceWanted());
        dto.setWriter(entity.getWriter());
        return dto;
    }
}
