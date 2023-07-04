package com.example.Miniproject_Market.dto.itemDto;

import com.example.Miniproject_Market.Entity.itemEntity;
import lombok.Data;

@Data
public class itemCreateDto {
    private Long id;
    private String title;
    private String description;
    private Integer minPriceWanted;
    private String writer;
    private String password;

    public static itemCreateDto createEntity(itemEntity entity) {
        itemCreateDto itemCreateDto = new itemCreateDto();
        itemCreateDto.setId(entity.getId());
        itemCreateDto.setDescription(entity.getDescription());
        itemCreateDto.setMinPriceWanted(entity.getMinPriceWanted());
        itemCreateDto.setWriter(entity.getWriter());
        itemCreateDto.setPassword(entity.getPassword());
        return itemCreateDto;
    }
}
