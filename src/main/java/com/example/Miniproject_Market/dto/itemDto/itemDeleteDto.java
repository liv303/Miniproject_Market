package com.example.Miniproject_Market.dto.itemDto;

import com.example.Miniproject_Market.Entity.itemEntity;
import lombok.Data;

@Data
public class itemDeleteDto {
    private Long id;
    private String password;

    public static itemDeleteDto deleteEntity(itemEntity entity) {
        itemDeleteDto deleteDto = new itemDeleteDto();
        deleteDto.setId(entity.getId());
        deleteDto.setPassword(entity.getPassword());
        return deleteDto;
    }
}
