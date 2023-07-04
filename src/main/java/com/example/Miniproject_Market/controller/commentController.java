package com.example.Miniproject_Market.controller;

import com.example.Miniproject_Market.dto.commentDto.commentDto;
import com.example.Miniproject_Market.dto.responseDto;
import com.example.Miniproject_Market.service.commentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @ResponseBody 포함
@RequestMapping("/items/{itemId}/comments")
@RequiredArgsConstructor
public class commentController {
    private final commentService service;

    // POST /items/{itemId}/comments
    @PostMapping
    public responseDto create(@PathVariable("itemId") Long itemId, @RequestBody commentDto dto) {
        // 댓글 생성
        service.createComment(itemId, dto);
        // 메시지
        responseDto response = new responseDto();
        response.setMessage("댓글이 등록되었습니다.");
        return response;
    }

    // GET /items/{itemId}/comments
    @GetMapping
    public List<commentDto> read(@PathVariable("itemId") Long itemId) {
        return service.readCommentAll(itemId);
    }

    // PUT /items/{itemId}/comments/{commentId}
    @PutMapping("/{commentId}")
    public commentDto update(
            @PathVariable("itemId") Long itemId,
            @PathVariable("commentId") Long commentId,
            @RequestBody commentDto dto
    ) {
        return service.updateCommet(itemId, commentId, dto);
    }


    // PUT /items/{itemId}/comments/{commentId}/reply
    @PutMapping("/{commentId}/reply")
    public void reply() {
    }


    // DELETE /items/{itemId}/comments/{commentId}
    @DeleteMapping("/{commentId}")
    public responseDto delete(@PathVariable("itemId") Long itemId, @PathVariable("commentId") Long commentId) {
        // 코멘트 삭제
        service.deleteComment(itemId, commentId);
        // 메시지
        responseDto response = new responseDto();
        response.setMessage("댓글을 삭제했습니다.");
        return response;
    }
}
