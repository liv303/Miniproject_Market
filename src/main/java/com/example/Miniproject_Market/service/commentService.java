package com.example.Miniproject_Market.service;

import com.example.Miniproject_Market.Entity.commentEntity;
import com.example.Miniproject_Market.dto.commentDto;
import com.example.Miniproject_Market.repository.commentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class commentService {
    private final commentRepository commentRepository;

    // 생성
    public commentDto createComment(Long itemId, commentDto dto) {
        commentEntity newComment = new commentEntity();
        newComment.setItemId(itemId);
        newComment.setWriter(dto.getWriter());
        newComment.setPassword(dto.getPassword());
        newComment.setContent(dto.getContent());
        newComment.setReply(dto.getReply());
        return commentDto.fromCommentEntity(commentRepository.save(newComment));
    }


    // 삭제
    public void deleteComment(Long itemId, Long commentId) {
        // 1) commentId가 맞는 코멘트가 있는지 확인
        Optional<commentEntity> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        // 2) itemId가 동일한지 확인
        commentEntity comment = optionalComment.get();
        if (!itemId.equals(comment.getItemId())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        // 삭제
        commentRepository.deleteById(commentId);
    }
}
