package com.example.Miniproject_Market.dto.itemDto;

import com.example.Miniproject_Market.Entity.itemEntity;
import lombok.Data;

@Data
public class itemUpdateDto {
    private Long id;
    private String title;
    private String description;
    private Integer minPriceWanted;
    private String writer;
    private String password;

    public static itemUpdateDto updateEntity(itemEntity entity) {
        itemUpdateDto updateDto = new itemUpdateDto();
        updateDto.setId(entity.getId());
        updateDto.setDescription(entity.getDescription());
        updateDto.setMinPriceWanted(entity.getMinPriceWanted());
        updateDto.setWriter(entity.getWriter());
        updateDto.setPassword(entity.getPassword());
        return updateDto;
    }
}
