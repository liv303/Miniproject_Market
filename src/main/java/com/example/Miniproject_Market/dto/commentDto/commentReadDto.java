package com.example.Miniproject_Market.dto.commentDto;

import com.example.Miniproject_Market.Entity.commentEntity;
import com.example.Miniproject_Market.dto.commentDto.commentDto;
import lombok.Data;

@Data
public class commentReadDto {
    private Long id;
    private Long itemId;
    private String writer;
    private String content;
    private String reply;

    public static commentDto fromCommentEntity(commentEntity entity) {
        commentDto dto = new commentDto();
        dto.setId(entity.getId());
        dto.setItemId(entity.getItemId());
        dto.setWriter(entity.getWriter());
        dto.setContent(entity.getContent());
        dto.setReply(entity.getReply());
        return dto;
    }
}
