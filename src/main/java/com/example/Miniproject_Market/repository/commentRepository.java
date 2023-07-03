package com.example.Miniproject_Market.repository;

import com.example.Miniproject_Market.Entity.commentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface commentRepository extends JpaRepository<commentEntity, Long> {
    // itemId가 id인 CommentEntity를 리스트에 넣음
    List<commentEntity> findAllByItemId(Long id);
}
