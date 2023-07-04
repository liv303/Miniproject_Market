package com.example.Miniproject_Market.dto.itemDto;

import com.example.Miniproject_Market.Entity.itemEntity;
import lombok.Data;
@Data
public class itemReadDto {
    private Long id;
    private String title;
    private String description;
    private Integer minPriceWanted;
    private String status;

    public static itemReadDto readEntity(itemEntity entity) {
        itemReadDto readDto = new itemReadDto();
        readDto.setId(entity.getId());
        readDto.setTitle(entity.getTitle());
        readDto.setDescription(entity.getDescription());
        readDto.setMinPriceWanted(entity.getMinPriceWanted());
        readDto.setStatus(entity.getStatus());
        return readDto;
    }
}

