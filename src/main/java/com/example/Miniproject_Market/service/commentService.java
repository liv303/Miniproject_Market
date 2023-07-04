package com.example.Miniproject_Market.service;

import com.example.Miniproject_Market.Entity.commentEntity;
import com.example.Miniproject_Market.dto.commentDto.commentDto;
import com.example.Miniproject_Market.repository.commentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
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

    // 특정 판매글의 댓글 전체 조회
    public List<commentDto> readCommentAll(Long itemId) {
        List<commentEntity> commentEntities = commentRepository.findAllByItemId(itemId);
        List<commentDto> commentList = new ArrayList<>();
        for (commentEntity entity: commentEntities) {
            commentList.add(commentDto.fromCommentEntity(entity));
        }
        return commentList;
    }

    // 수정
    public commentDto updateCommet(Long itemId, Long commentId, commentDto dto) {
        // 1) commentId가 맞는 코멘트가 있는지 확인
        Optional<commentEntity> optionalComment = commentRepository.findById(commentId);
            // 댓글이 존재하지 않으면 예외 발생
        if (optionalComment.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            // 존재하면 계속 진행
        commentEntity comment = optionalComment.get();

        // 2) itemId가 동일한지 확인
        if (!itemId.equals(comment.getItemId())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        // 수정
        comment.setContent(dto.getContent());
        return commentDto.fromCommentEntity(commentRepository.save(comment));
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
